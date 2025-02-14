package com.spring.devspring.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomLoginFailHandler implements AuthenticationFailureHandler {

	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
		
        log.info("[CustomLoginFailHandler] :: " + exception.getMessage());
        
        alertConfig.alertAndMovePage(response, "로그인 실패", "/admin");
        
        // response.sendRedirect("/admin");
        
    }

}
