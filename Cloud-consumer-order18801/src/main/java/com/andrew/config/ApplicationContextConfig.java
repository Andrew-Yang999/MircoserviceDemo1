package com.andrew.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Andrew Yang
 * @ClassName ApplicationContextConfig
 * @Description
 * @Package com.andrew.config
 * @Create 2021-08-03 16:35
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //测试自己的轮询算法MyLoadBalancer所以注释掉下面的Lb
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
