package com.qmcz.utils;

import com.qmcz.domain.User;
import com.qmcz.domain.vi.LoginUser;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author pcf
 * @date 2022/07/10
 * 生成用户，一般在crud时使用id来作为数据的唯一标识，防止不同用户之间数据乱
 */
@Data
public class UserGenerUtil {
    /**
     * 获取当前登录用户
     * @return User
     */
    public static HttpServletResponse response;
    public static HttpServletRequest request;

    public static LoginUser getCurrentUser(){
        HttpSession session = request.getSession();
        LoginUser user = (LoginUser) session.getAttribute("vip");
        return user;
    }
}
