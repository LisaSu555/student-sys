package com.qmcz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.domain.vi.UserVi;
import com.qmcz.mapper.UserMapper;
import com.qmcz.service.UserService;
import com.qmcz.utils.DataJudge;
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
    public TransformData<User> getUserList(User user) {
        TransformData<User> t = new TransformData<>();
        if(user.getPageNumber() == null){
            user.setPageNumber(1);
        }
        user.setPageStart((user.getPageNumber()-1)*user.getPageSize());
        // 查询出来所有数据
        List<User> userList = userMapper.selectUserList(user);
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
    public TransformData<User> addUser(UserVi user) {
        TransformData<User> t = new TransformData<>();
        // 非空判断
        if(user == null || user.getName() == null){
            t.setCode("3001");
            t.setMsg("新增的名称不能为空");
            return t;
        }
        // 传来的数据中有id说明需要修改
        if(user.getId() != null){
            User userTarget = new User();
            BeanUtils.copyProperties(user, userTarget);
            int i = userMapper.updateById(userTarget);
            t = DataJudge.judgeOperateResult(i, "修改", "1001", "失败");
        }else{
            // 查询新增的用户名称是否已经存在数据库， 即不能添加相同名称的用户
            QueryWrapper<User> qw = new QueryWrapper<>();
            qw.eq("name", user.getName());
            List<User> userList = userMapper.selectList(qw);
            // 名称相同就直接返回消息
            if(userList != null && userList.size() > 0){
                t.setCode("0002");
                t.setMsg("该用户已经存在");
                return t;
            }
            // 不为空不相同就执行插入操作
            int insertCount = userMapper.addUserByVi(user);
            t = DataJudge.judgeOperateResult(insertCount, "插入", "0001", "失败");
        }
        return t;
    }

    @Override
    public TransformData<User> editUser(User user) {
        TransformData<User> t = new TransformData<>();
        // 传来的之不能为空
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
        t = DataJudge.judgeOperateResult(updateCount, "修改", "1005", "失败");
        return t;
    }

    @Override
    public TransformData<User> getUserListApi(User user) {
        TransformData<User> tr = new TransformData<>();
        // 这里只需要判断传来的user是否为空
        if(user == null){
            // 为空就返回错误
            tr.setMsg("param not be null");
            tr.setCode("10001");
            return tr;
        }
        // 传来的user不为空就继续往下面走
        QueryWrapper<User> qw = new QueryWrapper<>();
        // user不为空，可以直接调用user的方法，进行比较字段
        // 一堆非空判断，再使用条件等价
        if(user.getId() != null){
            qw.eq("id" , user.getId());
        }
        if(user.getName() != null){
            qw.like("name", user.getName());
        }
        if(user.getAuthenCode() != null){
            qw.like("authen_code", user.getAuthenCode());
        }
        if(user.getSex() != null){
            qw.eq("sex", user.getSex());
        }
        // 查询出来的数据
        List<User> users = userMapper.selectList(qw);
        // 填充响应对象即可
        tr.setRows(users);
        tr.setCode("0000");
        if(users.isEmpty()){
            tr.setMsg("没有查询到你想要的数据");
        }else {
            tr.setMsg("查询成功");
        }
        // 返回响应对象
        return tr;
    }

    @Override
    public TransformData<User> deleteUser(User user) {
        TransformData<User> tr = new TransformData<>();
        // 非空判断
        if(user == null){
            tr.setMsg("必要的id参数要填写");
            tr.setCode("1001");
            return tr;
        }
        if(user.getId() == null){
            tr.setMsg("必要的id参数要填写");
            tr.setCode("1002");
            return tr;
        }
        // 所以可以只传来一个id，需要使用id查询这个user
        User userNeedBeDeleted = userMapper.selectById(user.getId());
        // 判断传来的对象的id是否存在于数据库
        if(userNeedBeDeleted == null){
            tr.setCode("2004");
            tr.setMsg("删除的用户不存在");
            return tr;
        }
        int deleteCount = userMapper.deleteById(user.getId());
        tr = DataJudge.judgeOperateResult(deleteCount, "删除", "1001", "失败");
        return tr;
    }
}
