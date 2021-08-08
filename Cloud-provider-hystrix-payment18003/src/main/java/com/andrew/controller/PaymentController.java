package com.andrew.controller;

import com.andrew.service.PaymentService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Create 2021-08-06 08:38
 */
@RestController
@RequestMapping("/payment/hystrix")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_ok(id);
        System.out.println("*****result:" + result);
        return result;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        System.out.println("*****result:" + result);
        return result;

    }
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBeaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBeaker(id);
        System.out.println("*****result:" + result);
        return result;

    }

}
