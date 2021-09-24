package com.example.newapi.configuration;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class DefaultAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Override
    public void commence(HttpServletRequest Request, HttpServletResponse Response, AuthenticationException e) throws IOException, ServletException {
        Response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}