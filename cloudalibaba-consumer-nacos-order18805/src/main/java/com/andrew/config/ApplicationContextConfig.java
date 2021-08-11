package com.andrew.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Andrew Yang
 * @className ApplicationContextConfig
 * @description
 * @package com.andrew.springcloud.config
 * @create 2021-05-30 16:05
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //开启restTemplate的请求负载均衡策略。
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
