package com.spring.devspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "/uploadPath/image/**" 경로로 들어오는 요청을 D://test/로 처리하도록 설정
        registry.addResourceHandler("/uploadPath/image/**")
                .addResourceLocations("file:/D:/uploadTest/images/");
    }
}