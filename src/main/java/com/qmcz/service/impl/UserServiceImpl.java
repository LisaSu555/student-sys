package com.qmcz.service.impl;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.mapper.UserMapper;
import com.qmcz.service.UserService;
import com.qmcz.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
}
