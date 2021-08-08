package com.andrew.service.impl;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.mapper.PaymentMapper;
import com.andrew.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${server.port}")
    private String serverPort;
    @Resource
    public PaymentMapper paymentMapper;

    @Override
    public CommonResult<PaymentEntity> select(Long id) {
        PaymentEntity paymentEntity = paymentMapper.select(id);
        if (paymentEntity != null) {
            return new CommonResult<>(200, "数据查询成功,serverPort:" + serverPort, paymentEntity);
        }
        return new CommonResult<>(500, "数据查询失败,serverPort:" + serverPort, null);
    }

    @Override
    public CommonResult<String> create(PaymentEntity paymentEntity) {
        int i = paymentMapper.create(paymentEntity);
        if (i > 0) {
            return new CommonResult<String>(200, "插入数据库成功,serverPort:" + serverPort, i + "");
        }
        return new CommonResult<String>(500, "插入数据库失败", null);
    }
}
