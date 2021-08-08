package com.andrew.controller;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author Andrew Yang
 * @ClassName PaymentController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-03 15:19
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    public PaymentService paymentService;
    @GetMapping("/select/{id}")
    public CommonResult<PaymentEntity> select(HttpServletRequest httpServletRequest, @PathVariable("id") Long id) {
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = httpServletRequest.getHeader(name);
            System.out.println(name + ":" + header);
        }
        return paymentService.select(id);
    }

    @PostMapping("/create")
    public CommonResult<String> create(@RequestBody PaymentEntity paymentEntity) {
        return paymentService.create(paymentEntity);
    }

    @GetMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }
}
