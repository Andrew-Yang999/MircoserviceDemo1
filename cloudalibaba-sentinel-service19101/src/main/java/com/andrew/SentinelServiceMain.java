package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Andrew Yang
 * @ClassName SentinelServiceMain
 * @Description
 * @Package com.andrew
 * @Create 2021-08-10 09:50
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain.class, args);
    }
}
