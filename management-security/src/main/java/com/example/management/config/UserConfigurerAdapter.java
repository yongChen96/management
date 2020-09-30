package com.example.management.config;

import com.example.commons.annotation.login.InjectUserResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ClassName: UserConfigurerAdapter
 * @Description: MVC配置
 * @Author: yongchen
 * @Date: 2020/8/27 14:24
 **/
@Configuration
public class UserConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public InjectUserResolver getInjectUserResolver(){
        return new InjectUserResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(getInjectUserResolver());
    }
}
