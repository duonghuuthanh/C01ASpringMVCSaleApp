/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.handlers;

import com.dht.pojo.User;
import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.dht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author duonghuuthanh
 */
@Component
public class LoginHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
            HttpServletResponse response, Authentication a) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userDetailsService.getUserByUsername(authentication.getName());
        request.getSession().setAttribute("currentUser", user);
        
        response.sendRedirect("/SunSaleApp");
    }
    
}
