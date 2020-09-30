package com.example.management.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yongchen
 * @Description: 用于配置白名单资源路径
 * @Date: 11:44 2020/9/1
 **/
@Data
@EnableConfigurationProperties({IgnoreUrlsConfig.class})
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();
}
