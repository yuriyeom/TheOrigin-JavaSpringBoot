package dev.glassym.exception.config;

import dev.glassym.exception.interceptor.HeaderLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoConfiguration implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(DemoConfiguration.class);

    private final HeaderLoggingInterceptor headerLoggingInterceptor;

    public DemoConfiguration(
            @Autowired HeaderLoggingInterceptor headerLoggingInterceptor
    ){
        this.headerLoggingInterceptor = headerLoggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerLoggingInterceptor)
                .addPathPatterns("/post/**")
                .excludePathPatterns("/except/**");
                // exclude된 경로에 대해서는 Interceptor가 일어나지 않는다.
                // header 내용이 안 찍힌다.
    }
}
