package com.kukuou.springbootfilter;

import com.kukuou.springbootfilter.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author olx
 * @date 2018/10/17/017
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        //添加拦截器
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login.do");

    }
}
