//package com.qmcz.webConfig;
//
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * 描述：
// *
// * @author pcf
// * @date  2019-01-27-13:38
// */
//@Configuration
//public class ShiroConfig {
//
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        // 给出登录的请求路径
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        // 不认证的请求路径？
//        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
//        // 创建一个map对象
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        // 所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
//        filterChainDefinitionMap.put("/pages/**", "anon");
//        filterChainDefinitionMap.put("/login/authen", "anon");
//        filterChainDefinitionMap.put("/front/**", "anon");
//        filterChainDefinitionMap.put("/api/**", "anon");
//        filterChainDefinitionMap.put("/teacher/**", "authc");
//        filterChainDefinitionMap.put("/user/**", "authc");
//        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
//        filterChainDefinitionMap.put("/**", "authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
//        defaultSecurityManager.setRealm(customRealm());
//        return defaultSecurityManager;
//    }
//
//    @Bean
//    public CustomRealm customRealm() {
//        return new CustomRealm();
//    }
//}
