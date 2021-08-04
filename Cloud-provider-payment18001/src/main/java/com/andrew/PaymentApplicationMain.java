package com.andrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Andrew Yang
 * @className OrderApplicationMain
 * @description
 * @package com.andrew.springcloud
 * @create 2021-05-30 16:00
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationMain.class, args);
    }
}
