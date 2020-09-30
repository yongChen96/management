package com.example.management.config;

import com.example.management.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * @ClassName: MySecurityConfig
 * @Description: Security配置
 * @Author: yongchen
 * @Date: 2020/9/1 15:55
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ManagementSecurityConfig extends SecurityConfig {

    @Resource
    private UserService userService;

    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userService.loadUserByUsername(username);
    }
}
