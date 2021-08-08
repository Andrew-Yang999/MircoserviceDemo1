package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Andrew Yang
 * @ClassName GatewayMain19002
 * @Description
 * @Package com.andrew
 * @Create 2021-08-07 22:22
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain19002 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain19002.class, args);
    }
}
