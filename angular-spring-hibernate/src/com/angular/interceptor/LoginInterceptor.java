package com.angular.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.angular.model.SystemRole;
import com.angular.model.SystemUser;
import com.angular.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = auth.getName();
            user = userService.findByUserName(email);
           
            session.setAttribute("user", user);
        }

        return super.preHandle(request, response, handler);
    }
}
