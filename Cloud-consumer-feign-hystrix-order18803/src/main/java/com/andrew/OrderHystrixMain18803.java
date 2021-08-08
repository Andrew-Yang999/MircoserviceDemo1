package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Andrew Yang
 * @ClassName OrderHystrixMain18803
 * @Description
 * @Package com.andrew
 * @Create 2021-08-06 09:10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain18803 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain18803.class, args);
    }
}
