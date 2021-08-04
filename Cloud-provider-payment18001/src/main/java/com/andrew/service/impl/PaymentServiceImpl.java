package com.andrew.service.impl;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.mapper.PaymentMapper;
import com.andrew.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Andrew Yang
 * @ClassName PaymentServiceImpl
 * @Description
 * @Package com.andrew.service.impl
 * @Create 2021-08-03 16:20
 */
@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    public PaymentMapper paymentMapper;

    @Override
    public PaymentEntity select(Long id) {
        return paymentMapper.select(id);
    }

    @Override
    public CommonResult<PaymentEntity> create(PaymentEntity paymentEntity) {
        int i = paymentMapper.create(paymentEntity);
        return new CommonResult<PaymentEntity>(200, i + "");
    }
}
