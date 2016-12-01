package org.wcb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.wcb.interceptor.LoginInterceptor;

/**
 * Created by wybe on 12/1/16.
 */

@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/book/**");
    }
}
