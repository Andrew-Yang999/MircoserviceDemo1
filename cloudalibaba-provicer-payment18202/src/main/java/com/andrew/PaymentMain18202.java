package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Andrew Yang
 * @ClassName PaymentMain18201
 * @Description
 * @Package com.andrew
 * @Create 2021-08-09 10:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain18202 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain18202.class, args);
    }
}
