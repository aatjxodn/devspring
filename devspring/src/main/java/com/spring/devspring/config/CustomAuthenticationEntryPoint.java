package com.spring.devspring.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		
        log.info("[CustomAuthenticationEntryPointHandler] :: {}", authException.getMessage());
        log.info("[CustomAuthenticationEntryPointHandler] :: {}", request.getRequestURL());
        log.info("[CustomAuthenticationEntryPointHandler] :: 로그인 인증 정보 없음");

        alertConfig.alertAndMovePage(response, "로그인 인증 정보 없음", "/admin");
        
        // response.sendRedirect("/admin");
    }

}