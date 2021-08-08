package com.andrew.controller;

import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @Author Andrew Yang
 * @ClassName PaymentController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-03 15:19
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    public DiscoveryClient discoveryClient;
    @Autowired
    public PaymentService paymentService;
    @GetMapping("/select/{id}")
    public CommonResult<PaymentEntity> select(HttpServletRequest httpServletRequest, @PathVariable("id") Long id) {
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = httpServletRequest.getHeader(name);
            System.out.println(name + ":" + header);
        }
        return paymentService.select(id);
    }

    @PostMapping("/create")
    public CommonResult<String> create(@RequestBody PaymentEntity paymentEntity) {
        return paymentService.create(paymentEntity);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("***********service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }
}
