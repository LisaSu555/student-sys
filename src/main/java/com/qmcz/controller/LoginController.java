package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.domain.vi.LoginUser;
import com.qmcz.domain.vo.UserAccount;
import com.qmcz.mapper.NormalQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.ListUtils;
import sun.security.util.Length;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录，就是用来登录的，也可以登录验证。
 * @author pcf
 * @date 2022/01/23
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private NormalQueryMapper normalQueryMapper;

    /**
     * 直接跳转到登陆界面
     * @return 登录界面的跳转
     */
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
    @ResponseBody
    @RequestMapping("/authen")
    public TransformData authenUser(LoginUser loginUser , HttpServletRequest req, HttpServletResponse resp){
        TransformData tr = new TransformData();
        List<UserAccount> userList = normalQueryMapper.selectData();
        int a = 0;
        if(!ListUtils.isEmpty(userList)){
            for (UserAccount userAccount:userList) {
                String input_name = loginUser.getName();
                String input_password = loginUser.getPassword();
                String name = userAccount.getName();
                String psw = userAccount.getPsw();

                if(input_name!=null&&input_name.equals(name)){
                    if(input_password!=null&&input_password.equals(psw)){
                        //登录成功 Todo
                        req.setAttribute("vip", userAccount);
                        System.out.println("登录成功");
                        tr.setMsg("登录成功");
                        tr.setCode("0000");
                        return tr;
                    }else {
                        //密码错误 Todo
                        req.removeAttribute("vip");
                        System.out.println("密码错误！");
                        tr.setCode("0001");
                        tr.setMsg("密码错误");
                        return tr;
                    }
                }else {
                    tr.setCode("0001");
                    tr.setMsg("可能是你是账号写错了！");
                    return tr;
                }
            }
        }
        return tr;
    }
}
