package com.qmcz.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Order(1)
@WebFilter(filterName = "myFilter1",urlPatterns = {"/*"})
public class MyFilter implements Filter {

    @Autowired
    private JwtUitls jwtUitls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<String,String> map = new HashMap<>();
        String url =  ((HttpServletRequest)servletRequest).getRequestURI();
        if(url != null){
            //登录请求直接放行
            if("/login".equals(url)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else{
                //其他请求验证token
                String token = ((HttpServletRequest)servletRequest).getHeader("token");
                if(StringUtils.isNotBlank(token)){
                    //token验证结果
                    int verify  = jwtUitls.verify(token);
                    if(verify != 1){
                        //验证失败
                        if(verify == 2){
                            map.put("errorMsg","token已过期");
                        }else if(verify == 0){
                            map.put("errorMsg","用户信息验证失败");
                        }
                    }else if(verify  == 1){
                        //验证成功，放行
                        filterChain.doFilter(servletRequest,servletResponse);
                        return;
                    }
                }else{
                    //token为空的返回
                    map.put("errorMsg","未携带token信息");
                }
            }
            JSONObject jsonObject = new JSONObject(map);
            servletResponse.setContentType("application/json");
            //设置响应的编码
            servletResponse.setCharacterEncoding("utf-8");
            //响应
            PrintWriter pw=servletResponse.getWriter();
            pw.write(jsonObject.toString());
            pw.flush();
            pw.close();
        }
    }
 
    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了");
    }
}