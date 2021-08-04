package com.andrew.controller;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    public PaymentService paymentService;
    @GetMapping("/select/{id}")
    public PaymentEntity select(@PathVariable("id") Long id) {
        return paymentService.select(id);
    }

    @PostMapping("/create")
    public CommonResult<PaymentEntity> create(@RequestBody PaymentEntity paymentEntity) {
        return paymentService.create(paymentEntity);
    }
}
