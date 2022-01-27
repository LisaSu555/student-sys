package com.qmcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录，就是用来登录的，也可以登录验证。
 * @author pcf
 * @date 2022/01/23
 */
@Controller
@RequestMapping("")
public class LoginController {

    /**
     * 直接跳转到登陆界面
     * @return 登录界面的跳转
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 不知道这个认证方法有没有用
     * 不知道逻辑，就不是很好搞
     * @return 消息字段
     */
    @RequestMapping("/authen")
    public String authenUser(){
        return "";
    }
}
