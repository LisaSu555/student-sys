package com.qmcz.webConfig;

import com.qmcz.domain.vi.LoginUser;
import com.qmcz.utils.TimeUtil;
import com.qmcz.utils.UserGenerUtil;
import org.jetbrains.annotations.NotNull;
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
    public boolean preHandle(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp, @NotNull Object handler){
        System.out.println("执行拦截了请求");
        try {
            //统一拦截,查询当前session是否存在user,这里user每次登录后会存入session
            //后端给前端传递的数据名称
            LoginUser user= (LoginUser) req.getSession().getAttribute("vip");
            if (user!=null){
                UserGenerUtil.response = resp;
                UserGenerUtil.request = req;
                System.out.println("放行");
                return true;
            }
            //对拦截到的进行重定向
            System.out.println("返回登录界面");
            resp.sendRedirect("/login");
        }catch (IOException io){
            io.printStackTrace();
        }
        //如果设置为false时,被请求时,拦截器执行到此不再执行,相反会继续执行下面的操作
        return false;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp, @NotNull Object handler, ModelAndView modelAndView){
        //String nowTimeToSS = TimeUtil.getNowTimeToSS();
        //请求处理以后进行调用,Controller方法之后
        //System.out.println("执行了Posthandler方法:"+nowTimeToSS);
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp, @NotNull Object handler, Exception ex){
        //String nowTimeToSS = TimeUtil.getNowTimeToSS();
        //System.out.println("执行了afterCompletion:"+nowTimeToSS);
        //在整个请求结束之后,渲染了对应的视图以后执行,主要用于资源清理工作
    }
}
