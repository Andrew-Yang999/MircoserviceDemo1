package com.andrew.lb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Andrew Yang
 * @ClassName MyLoadBalancer
 * @Description
 * @Package com.andrew.lb
 * @Create 2021-08-05 17:42
 */
@Component
public class MyLoadBalancer implements LoadBalancer {
    @Autowired
    public DiscoveryClient discoveryClient;
    public AtomicInteger atomicInteger = new AtomicInteger(0);

    public int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int integer = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(integer);
    }
}
