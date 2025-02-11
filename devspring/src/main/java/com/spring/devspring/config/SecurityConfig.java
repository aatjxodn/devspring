package com.spring.devspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.spring.devspring.user.CtUserService;

import lombok.RequiredArgsConstructor;


@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final CtUserService ctUserService;
    private final CustomLoginSuccessHandler customLoginSuccessHandler;
    private final CustomLoginFailHandler customLoginFailHandler;
    private final CustomLogoutSuccessHandler customLogoutSuccessHandler;
    
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
		
		// form login 중복 실행 방지
        http.formLogin(login -> login
        		.loginPage("/admin")
        		.usernameParameter("ctUserId")
        		.passwordParameter("ctUserPwd")
                .loginProcessingUrl("/login/loginProcess")
                .defaultSuccessUrl("/adminMain")
                .successHandler(customLoginSuccessHandler)
                .failureHandler(customLoginFailHandler)
        );
        
        // logout 설정
        http.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
        );
        
	     // http request 인증 설정
	    http.authorizeHttpRequests(authorize -> authorize
	            .requestMatchers("/**").permitAll()
	            .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
	            .anyRequest().authenticated()
	    );

	    // 인증 없는 사용자 URL 접근 시
        http.exceptionHandling(handling -> handling
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()))
        ;
	    
	    // csrf disable
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(ctUserService).passwordEncoder(passwordEncoder());
	}
	
}