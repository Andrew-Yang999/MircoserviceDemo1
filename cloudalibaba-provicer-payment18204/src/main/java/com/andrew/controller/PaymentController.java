package com.andrew.controller;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author Andrew Yang
 * @ClassName PaymentController
 * @Description
 * @Package com.andrew.springcloud.controller
 * @Create 2021-07-28 09:11
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, PaymentEntity> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new PaymentEntity(1L, "1111111111111111111111111111111111111"));
        hashMap.put(2L, new PaymentEntity(2L, "2222222222222222222222222222222222222"));
        hashMap.put(3L, new PaymentEntity(3L, "3333333333333333333333333333333333333"));
    }

    @GetMapping(value = "/PaymentEntitySql/{id}")
    public CommonResult<PaymentEntity> PaymentEntitySql(@PathVariable("id") Long id) {
        PaymentEntity paymentEntity = hashMap.get(id);
        return new CommonResult<>(200, "from mysql, server port: " + serverPort, paymentEntity);
    }
}
