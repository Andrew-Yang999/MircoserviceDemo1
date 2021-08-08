package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author Andrew Yang
 * @ClassName ConfigCenterMain19003
 * @Description
 * @Package com.andrew
 * @Create 2021-08-08 16:17
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain19003 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain19003.class, args);
    }
}
