package com.andrew.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Andrew Yang
 * @ClassName PaymentController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-09 10:22
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    public String serverPort;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping(value = "/nacos/{id}")
    public String getPayment(@PathVariable("id") String id) {
        return "Hello Nacos Discovery, serverPort" + serverPort + "id:" + id;
    }

}
