package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author Andrew Yang
 * @ClassName HystrixDashboardMain19001
 * @Description
 * @Package com.andrew
 * @Create 2021-08-07 21:29
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain19001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain19001.class);
    }
}

