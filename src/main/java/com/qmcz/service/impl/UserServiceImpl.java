package com.qmcz.service.impl;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.mapper.UserMapper;
import com.qmcz.service.UserService;
import com.qmcz.utils.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pcf
 * @date 01/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public TransformData<User> getUserList() {
        TransformData<User> t = new TransformData<>();

        List<User> userList = userMapper.selectUserList();
        if(userList != null && userList.size()>0){
            t.setRows(userList);
            t.setCode("0000");
            t.setMsg("查询到数据了");
        }else{
            t.setCode("0001");
            t.setMsg("没有数据，或者数据集合为空");
        }
        return t;
    }

    @Override
    public TransformData<User> addUser(User user) {
        TransformData<User> t = new TransformData<>();
        int insert_count = userMapper.insert(user);
        if (insert_count == 0){
            t.setCode("0001");
            t.setMsg("错误，没有插入任何数据");
            t.setRows(null);
        }else if (insert_count == 1){
            String time_string = TimeUtil.getNowTimeToSS();
            t.setCode("0000");
            t.setMsg("成功插入一条数据,操作时间是"+time_string);
            t.setRows(null);
        }else {
            t.setCode("1111");
            t.setMsg("错误，后台报错");
            t.setRows(null);
        }
        return t;
    }

    @Override
    public TransformData<User> editUser(User user) {
        TransformData<User> t = new TransformData<>();
        // 不能传来的值是空的（null）
        if(user==null){
            t.setCode("1002");
            t.setMsg("修改的用户参数必须填写完整");
            return t;
        }
        // 传来的对象中的id不能为空
        if(user.getId()==null){
            t.setCode("1003");
            t.setMsg("修改的用户的id必须填写");
            return t;
        }
        // 传来的对象中的name不能为空
        if(user.getName()==null || "".equals(user.getName())){
            t.setCode("1003");
            t.setMsg("修改的用户的名称必须填写");
            return t;
        }
        // 所以可以只传来一个id，需要使用id查询这个user，能查到就开始修改
        User userNeedBeEdit = userMapper.selectById(user.getId());
        // 判断传来的对象的id是否存在于数据库
        if(userNeedBeEdit == null){
            t.setCode("1004");
            t.setMsg("修改的用户不存在");
            return t;
        }
        // 所有判断过后， 查询来的userNeedBeEdit和传来的user的id是一样的，其他填写的不一定相同, 将传入的user属性同步给userNeedBeEdit
        // 如果只传来一个id，那么该对象其他属性全部被清空
        BeanUtils.copyProperties(user, userNeedBeEdit);
        // userNeedBeEdit已经在内存中获得更新，然后写入数据库
        int updateCount = userMapper.updateById(userNeedBeEdit);
        if(updateCount != 1){
            t.setCode("1005");
            t.setMsg("修改用户失败，位置错误");
            return t;
        }else {
            t.setCode("0000");
            t.setMsg("修改成功");
        }
        return null;
    }
}
