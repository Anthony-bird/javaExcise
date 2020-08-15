package com.feng.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制请求的授权规则
        // 首页所有人可以访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        // 开启自动配置的登录功能
        http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");
        //注销
        http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
        http.logout().logoutSuccessUrl("/");
        //记住我

        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Spring security 5.0中新增了多种加密方式，也改变了密码的格式 我们要将前端传过来的密码进行某种方式加密
        //springboot 2.1.x可以直接使用
        //spring security 官方推荐的是使用bcrypt加密方式。

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
