package com.qmcz.webConfig;

import com.qmcz.domain.User;
import com.qmcz.domain.vi.LoginUser;
import com.qmcz.utils.UserGenerUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pcf
 * @date 2022/07/10
 * 请求拦截器
 */
public class HandlerInterceptorMy implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler){
        System.out.println("执行了preHandle方法");
        try {
            //统一拦截,查询当前session是否存在user,这里user每次登录后会存入session
            //后端给前端传递的数据名称
            LoginUser user= (LoginUser) req.getSession().getAttribute("vip");
            if (user!=null){
                UserGenerUtil.response = resp;
                UserGenerUtil.request = req;
                return true;
            }
            //对拦截到的进行重定向
            resp.sendRedirect("/login");
        }catch (IOException io){
            io.printStackTrace();
        }
        //如果设置为false时,被请求时,拦截器执行到此不再执行,相反会继续执行下面的操作
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView modelAndView){
        //请求处理以后进行调用,Controller方法之后
        System.out.println("执行了Posthandler方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex){
        System.out.println("执行了afterCompletion");
        //在整个请求结束之后,渲染了对应的视图以后执行,主要用于资源清理工作
    }
}
