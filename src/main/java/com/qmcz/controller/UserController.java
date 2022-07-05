package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pcf
 * @date 2022/01/27
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public TransformData<User> getUserList(){
        return userService.getUserList();
    }

    @RequestMapping("/add_user")
    @ResponseBody
    public TransformData<User> AddUser(User user){
        return userService.addUser(user);
    }

}
