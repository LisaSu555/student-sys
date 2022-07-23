package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.domain.vi.LoginUser;
import com.qmcz.domain.vo.UserAccount;
import com.qmcz.mapper.NormalQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.ListUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
     * 直接跳转到登陆界面，同上面，只是请求路径的区别
     * @return 登录界面的跳转
     */
    @RequestMapping("/login")
    public String login(ModelMap map){
        map.addAttribute("name","hello");
        return "pages/login";
    }

    /**
     * 登录验证，涉及到session
     * @return 消息对象
     */
    @ResponseBody
    @PostMapping("/authen")
    public TransformData authenUser(LoginUser loginUser , HttpServletRequest req, HttpServletResponse resp){
        //获取session
        HttpSession session = req.getSession();
        //创建消息对象
        TransformData tr = new TransformData();
        //查询所有用户
        List<UserAccount> userList = normalQueryMapper.selectData();
        //判断输入的账号密码是否正确
        if(!ListUtils.isEmpty(userList)){
            for (UserAccount userAccount:userList) {
                //得到输入的账号和密码，和数据库中的所有数据进行对比
                String inputName = loginUser.getName();
                String inputPassword = loginUser.getPassword();
                String name = userAccount.getName();
                String psw = userAccount.getPsw();

                if(inputName!=null&&inputName.equals(name)){
                    //账号密码均相同
                    if(inputPassword!=null&&inputPassword.equals(psw)){
                        //登录成功后在session中存入对象
                        session.setAttribute("vip", loginUser);
                        //设置session过期时间
                        session.setMaxInactiveInterval(2000);
                        System.out.println("登录成功");
                        //设置消息体
                        tr.setMsg("登录成功");
                        tr.setCode("0000");
                    }else {//账号正确密码错误
                        //登录失败则清空session，则需要重新登录
                        session.removeAttribute("vip");
                        tr.setCode("0001");
                        tr.setMsg("密码错误");
                    }
                }else {//其他情况
                    session.removeAttribute("vip");
                    tr.setCode("0001");
                    tr.setMsg("可能是你是账号写错了！");
                }
                return tr;
            }
        }
        return tr;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp){
        LoginUser vip = (LoginUser)req.getSession().getAttribute("vip");
        if(vip != null){
            req.getSession().removeAttribute("vip");
        }
        return "pages/login";
    }
}
