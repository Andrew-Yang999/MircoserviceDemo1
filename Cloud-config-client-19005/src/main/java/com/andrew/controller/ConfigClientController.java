package com.andrew.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrew Yang
 * @className ConfigClientController
 * @description
 * @package com.andrew.springcloud.controller
 * @create 2021-06-09 16:24
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
