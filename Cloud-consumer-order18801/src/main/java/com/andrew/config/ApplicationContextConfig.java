package com.andrew.config;

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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
