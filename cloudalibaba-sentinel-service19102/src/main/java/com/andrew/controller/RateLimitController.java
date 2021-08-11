package com.andrew.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Andrew Yang
 * @ClassName RateLimitController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-10 21:41
 */
@RestController
public class RateLimitController {

    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {

        return new CommonResult(200, "按资源名称限流测试ok", new PaymentEntity(2000L, "serial001"));
    }

//    public CommonResult handleException(BlockException exception) {
//        return new CommonResult(400, exception.getClass().getCanonicalName() + "\t服务不可用");
//    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult rateLimitByUrl() {

        return new CommonResult(200, "按资源名称限流测试ok", new PaymentEntity(2000L, "serial001"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handleException2")
    public CommonResult customerBlockHandler() {

        return new CommonResult(200, "按客户自定义-全局同一兜底", new PaymentEntity(2000L, "serial001"));
    }
}
