package com.andrew.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Andrew Yang
 * @ClassName LoadBalancer
 * @Description
 * @Package com.andrew.lb
 * @Create 2021-08-05 17:40
 */
public interface LoadBalancer {
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
