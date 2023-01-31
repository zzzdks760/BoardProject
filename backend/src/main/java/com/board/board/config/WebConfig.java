package com.board.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8585", "http://localhost:8080")
                .allowedMethods("*")
                .maxAge(3000);
    }
}