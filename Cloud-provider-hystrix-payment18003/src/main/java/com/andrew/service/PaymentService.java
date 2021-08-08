package com.andrew.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Andrew Yang
 * @ClassName PaymentService
 * @Description
 * @Package com.andrew.service
 * @Create 2021-08-06 08:35
 */
public interface PaymentService {
    public String paymentInfo_ok(Integer id);
    public String paymentInfo_TimeOut(Integer id);

    @HystrixCommand(fallbackMethod = "paymentCircuitBeaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBeaker.enable", value = "true"),
            @HystrixProperty(name = "circuitBeaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBeaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBeaker.errorThresholdPercentage", value = "60")
    })
    String paymentCircuitBeaker(@PathVariable("id") Integer id);
}
