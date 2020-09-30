package com.example.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yongchen
 */
@SpringBootApplication
@ComponentScan("com.example.management.mapper")
public class ManagementRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementRestApplication.class, args);
    }

}
