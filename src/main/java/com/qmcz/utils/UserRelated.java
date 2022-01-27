package com.qmcz.utils;

import com.qmcz.domain.User;

/**
 * 用户相关的类
 * 可以获取用户的id什么的
 * 供其他类调用的
 * @author pcf
 * @date 2022/01/27
 */
public class UserRelated {

    public User getUserById(){
        User user = new User();
        return user;
    }

}
