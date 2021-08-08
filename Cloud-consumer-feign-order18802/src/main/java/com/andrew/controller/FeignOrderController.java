package com.andrew.controller;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Andrew Yang
 * @ClassName FeignOrderController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-05 21:23
 */
@RestController
@RequestMapping("/feign")
public class FeignOrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/select/{id}")
    public CommonResult<PaymentEntity> select(@PathVariable("id") Long id) {
        return paymentFeignService.select(id);
    }
    @GetMapping("/timeout")
    public String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
