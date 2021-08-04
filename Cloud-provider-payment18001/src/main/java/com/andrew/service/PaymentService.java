package com.andrew.service;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;

/**
 * @Author Andrew Yang
 * @ClassName PaymentService
 * @Description
 * @Package com.andrew.service
 * @Create 2021-08-03 16:20
 */
public interface PaymentService {
    public PaymentEntity select(Long id);

    public CommonResult<PaymentEntity> create(PaymentEntity paymentEntity);
}
