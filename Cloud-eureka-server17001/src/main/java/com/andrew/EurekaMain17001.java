package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Andrew Yang
 * @ClassName EurekaMain17071
 * @Description
 * @Package com.andrew
 * @Create 2021-08-03 21:56
 */
@SpringBootApplication
//开启eureka服务端
@EnableEurekaServer
public class EurekaMain17001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain17001.class, args);
    }
}
