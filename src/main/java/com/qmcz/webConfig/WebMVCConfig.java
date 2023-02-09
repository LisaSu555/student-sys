//package com.qmcz.webConfig;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 请求拦截配置类
// */
//@Configuration
//public class WebMVCConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册TestInterceptor拦截器,将自定义的请求拦截器放入其中
//        InterceptorRegistration registration = registry.addInterceptor(new HandlerInterceptorMy());
//        //请求拦截
//        registration.addPathPatterns("/**");
//        //放行的请求
//        registration.excludePathPatterns("/login",
//                "/login/authen",
//                "/**/*.html",
//                "/**/*.css",
//                "/**/*.js",
//                "/**/*.gif",
//                "/**/*.jpg",
//                "/**/*.png",
//                "/**/*.ico",
//                "/**/*.jpeg"
//        );//添加不被拦截的路径,有很多静态资源
//    }
//}
