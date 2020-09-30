package com.example.management.config;

import com.example.commons.config.BaseSwaggerConfig;
import com.example.commons.entity.SwaggerProperties;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Description: Swagger配置
 * @Author: yongchen
 * @Date: 2020/9/1 15:50
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.example.management.controller")
                .title("managenemt 后台系统")
                .description("managenemt后台相关接口文档")
                .contactName("yongchen")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
