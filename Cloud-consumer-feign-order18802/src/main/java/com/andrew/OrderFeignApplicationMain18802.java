package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Andrew Yang
 * @className OrderApplicationMain
 * @description
 * @package com.andrew.springcloud
 * @create 2021-05-30 16:00
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class OrderFeignApplicationMain18802 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplicationMain18802.class, args);
    }
}
