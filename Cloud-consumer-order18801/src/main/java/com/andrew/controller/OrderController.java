package com.andrew.controller;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT/";
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/select/{id}")
    public CommonResult<PaymentEntity> select(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult<PaymentEntity>> responseEntity = restTemplate.exchange(PAYMENT_URL + "payment/select/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<CommonResult<PaymentEntity>>() {
        });
        return responseEntity.getBody();
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

    @GetMapping("/lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if (instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instances(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
