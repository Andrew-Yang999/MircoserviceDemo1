package com.andrew.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author Andrew Yang
 * @ClassName FlowLimitController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-10 09:53
 */
@RestController
@RequestMapping("/sentinel")
public class FlowLimitController {
    private final RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    public FlowLimitController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/testA")
    public String testA() {
//        try {
//
//    TimeUnit.MILLISECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "----------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println("1111111111111111" + LocalDateTime.now());
        return "----------testB";
    }

    @GetMapping(value = "/testC/{id}")
    public String getPaymentByTestC(@PathVariable("id") String id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }

    @GetMapping(value = "/testD/{id}")
    public String getPaymentByTestD(@PathVariable("id") String id) {

        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }

    @GetMapping("/testE")
    public String testE() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1111111111111111" + LocalDateTime.now());
        return "----------testE";
    }
}
