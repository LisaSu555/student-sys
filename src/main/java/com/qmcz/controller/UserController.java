package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author pcf
 * @date 2022/01/27
 */
@Controller
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String getUserList(ModelMap modelMap){
        TransformData<User> userListTrans = userService.getUserList();
        List<User> userList = userListTrans.getRows();
        modelMap.addAttribute("list", userList);
        return "pages/user/userList";
    }

    @RequestMapping("/to_add_page")
    public String toAddPage(ModelMap modelMap){
        modelMap.addAttribute("test","one");
        return "pages/user/userAdd";
    }

    @RequestMapping("/add_user")
    @ResponseBody
    public TransformData<User> AddUser(User user){
        return userService.addUser(user);
    }

}
