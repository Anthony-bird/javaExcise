package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 如果是登陆页面则放行

        if (request.getRequestURI().contains("goLogin")) {
            return true;
        }

        if (request.getRequestURI().contains("login")) {
            return true;
        }

        // 如果用户已登陆也放行
        if (session.getAttribute("userLoginInfo") != null) {
            return true;
        }

        // 用户没有登陆跳转到登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
