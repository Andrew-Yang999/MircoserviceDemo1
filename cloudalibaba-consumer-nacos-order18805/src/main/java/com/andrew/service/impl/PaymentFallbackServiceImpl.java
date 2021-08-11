package com.andrew.service.impl;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author Andrew Yang
 * @ClassName PaymentService
 * @Description
 * @Package com.andrew.service.impl
 * @Create 2021-08-11 14:58
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult<PaymentEntity> paymentSql(Long id) {
        return new CommonResult<>(4444,"服务降级返回，----paymentFallbackService",new PaymentEntity(id,"errorSerial"));
    }
}
