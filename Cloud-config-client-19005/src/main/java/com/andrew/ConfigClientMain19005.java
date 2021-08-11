package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Andrew Yang
 * @ClassName ConfigCenterMain19003
 * @Description
 * @Package com.andrew
 * @Create 2021-08-08 16:17
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain19005 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain19005.class, args);
    }
}
