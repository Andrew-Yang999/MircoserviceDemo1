package com.andrew.service;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Andrew Yang
 * @ClassName PaymentFeignService
 * @Description
 * @Package com.andrew.service
 * @Create 2021-08-05 21:22
 */
@Service
@FeignClient("CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {
    @GetMapping("/payment/select/{id}")
    CommonResult<PaymentEntity> select(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout();
}
