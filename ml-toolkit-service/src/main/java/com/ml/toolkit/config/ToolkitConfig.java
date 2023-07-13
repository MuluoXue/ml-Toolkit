package com.ml.toolkit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 过滤器配置
 * @author ml
 * @date 2022年12月27日 19:27
 */
@Configuration
public class ToolkitConfig implements WebMvcConfigurer {

    @Resource
    private TokenHandlerInterceptor tokenHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenHandlerInterceptor);
    }
}
