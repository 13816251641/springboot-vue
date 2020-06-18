package com.lujieni.vue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 设置允许跨域访问
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true) //允许cookie跨域 端口不一样也是跨域
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}
