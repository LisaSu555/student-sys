package com.qmcz.controller;

import com.qmcz.domain.User;
import com.qmcz.domain.vi.LoginUser;
import com.qmcz.mapper.NormalQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 登录，就是用来登录的，也可以登录验证。
 * @author pcf
 * @date 2022/01/23
 */
@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    private NormalQueryMapper normalQueryMapper;
    @RequestMapping("")
    public String index(ModelMap map){
        map.addAttribute("name","hello");
        return "pages/login";
    }

    /**
     * 直接跳转到登陆界面
     * @return 登录界面的跳转
     */
    @RequestMapping("/login")
    public String login(ModelMap map){
        map.addAttribute("name","hello");
        return "page/login";
    }

    /**
     * 不知道这个认证方法有没有用
     * 不知道逻辑，就不是很好搞
     * 这个不应该是请求功能而应该是一般方法
     * 是需要被调用的
     * @return 消息字段
     */
    @RequestMapping("/authen")
    public String authenUser(LoginUser loginUser){
        List<User> userList = normalQueryMapper.selectData();
        //userList.forEach();
        return "";
    }
}
