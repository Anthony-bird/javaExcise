package com.feng.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);


        /*anon:无需认 证就可以访问
        authc:必须认证了 才能让问
        user:.必须拥有 记住我功能才能用
        perms:
        拥有对某个资源的权限才能访间:
        role:拥有某 个角色权限才能访问
        */
        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/user/add", "authc");
//        filterMap.put("/user/update", "authc");
        filterMap.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置获录的请求
        bean.setLoginUrl("/toLogin");

        return bean;

    }

    //DefaultWebSecurityManager:2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultwebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //.关联UserReaLm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象，需要自定义类:1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
