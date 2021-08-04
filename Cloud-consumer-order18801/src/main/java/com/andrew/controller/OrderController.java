package com.andrew.controller;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Andrew Yang
 * @ClassName PaymentController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-03 15:19
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final String PAYMENT_URL = "http://localhost:18001/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/select/{id}")
    public PaymentEntity select(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "payment/select/" + id, PaymentEntity.class);
    }

    @PostMapping("/create")
    public CommonResult<PaymentEntity> create(@RequestBody PaymentEntity paymentEntity) {
        ResponseEntity<CommonResult<PaymentEntity>> responseEntity = restTemplate.exchange(PAYMENT_URL + "payment/create", HttpMethod.POST, new HttpEntity<>(paymentEntity), new ParameterizedTypeReference<CommonResult<PaymentEntity>>() {
        });
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        return new CommonResult<>(500, "操作失败");
    }
}
