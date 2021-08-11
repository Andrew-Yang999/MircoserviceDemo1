package com.andrew.service;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Andrew Yang
 * @ClassName PaymentService
 * @Description
 * @Package com.andrew.service
 * @Create 2021-08-11 14:53
 */
@FeignClient(value="cloudalibaba-provicer-payment",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {
    @GetMapping("/PaymentEntitySql/{id}")
    CommonResult<PaymentEntity> paymentSql(@PathVariable("id") Long id);
}
