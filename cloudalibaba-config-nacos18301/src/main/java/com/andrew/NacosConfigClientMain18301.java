package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Andrew Yang
 * @ClassName NacosConfigClientMain18301
 * @Description
 * @Package com.andrew
 * @Create 2021-08-09 16:58
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain18301 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain18301.class, args);
    }
}
