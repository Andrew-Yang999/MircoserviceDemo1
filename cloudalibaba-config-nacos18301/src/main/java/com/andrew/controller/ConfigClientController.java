package com.andrew.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Andrew Yang
 * @ClassName ConfigClientController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-09 17:00
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    public String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

}


