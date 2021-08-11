package com.andrew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Andrew Yang
 * @ClassName PaymentController
 * @Description
 * @Package com.andrew.springcloud.controller
 * @Create 2021-07-24 21:27
 */
@RestController
@RequestMapping("/consumer")
public class OrderNacosController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/nacos/{id}")
    public String getPayment(@PathVariable("id") String id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }
}