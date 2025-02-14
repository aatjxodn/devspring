package com.spring.devspring.security;

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
                .loginProcessingUrl("/user/loginProcess")
                .defaultSuccessUrl("/adminMain")
                .successHandler(customLoginSuccessHandler)
                .failureHandler(customLoginFailHandler)
        );
        
        // logout 설정
        http.logout(logout -> logout
                .logoutUrl("/user/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
        );
        
	     // http request 인증 설정
	    http.authorizeHttpRequests(authorize -> authorize
	            .requestMatchers("/adminMain").authenticated()
	            .requestMatchers("/css/**", "/js/**", "/images/**","/mapper/**").permitAll()
	            .anyRequest().permitAll()
	    );

	    // 인증 없는 사용자 URL 접근 시
        http.exceptionHandling(handling -> handling
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()))
        ;
        
        // 세션 관리 설정 (세션 타임아웃 30분)
        http.sessionManagement(session -> session
                .sessionFixation().none()
                .invalidSessionUrl("/login?sessionExpired=true") // 세션 만료 시 리디렉션
                .maximumSessions(1) // 동시에 하나의 세션만 허용
                .maxSessionsPreventsLogin(false) // 기존 세션 종료 후 새 로그인 허용
        );
	    
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