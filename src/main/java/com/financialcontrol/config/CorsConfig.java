package com.financialcontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "https://financial-control-frontend-1h89.vercel.app",
                                "https://financial-control-frontend-1h89.vercel.app/",
                                "https://financial-control-fron-git-7c619f-devcarloshenriquehcs-projects.vercel.app/",
                                "https://financial-control-frontend-1h89-devcarloshenriquehcs-projects.vercel.app/",
                                "https://financial-control-fron-git-7c619f-devcarloshenriquehcs-projects.vercel.app",
                                "https://financial-control-frontend-1h89-devcarloshenriquehcs-projects.vercel.app"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

}
