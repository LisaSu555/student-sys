package com.qmcz.utils;

import com.qmcz.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 生成用户，一般在crud时使用id来作为数据的唯一标识，防止不同用户之间数据乱
 */
public class UserGenerUtil {
    /**
     * 获取当前登录用户
     * @return User
     */
    public static User getCurrentUser(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("vip");
        return user;
    }
}
