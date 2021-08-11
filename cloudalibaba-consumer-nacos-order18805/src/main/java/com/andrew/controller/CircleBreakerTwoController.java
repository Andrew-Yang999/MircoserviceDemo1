package com.andrew.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.andrew.entity.CommonResult;
import com.andrew.entity.PaymentEntity;
import com.andrew.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Andrew Yang
 * @ClassName CircleBreakerController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-11 09:50
 */
@RestController
public class CircleBreakerTwoController {
    @Value("${service-url.nacos-user-service}")
    public String SERVICE_URL;
    @Resource
    private PaymentService paymentService;
//    @Autowired
//    public RestTemplate restTemplate;
//
//    @RequestMapping("/consumer/fallback/{id}")
////    @SentinelResource(value = "fallback") //没有配置
////    @SentinelResource(value = "fallback", fallback = "handlerFallback") //只配置fallback
////    @SentinelResource(value = "fallback", blockHandler = "blockHandler") //只配置blockedHandler
////    @SentinelResource(
////            value = "fallback",
////            fallback = "handlerFallback",   //只负责java的运行时异常
////            blockHandler = "blockHandler" //只负责sentinel拦截的配置异常
////    )
//    @SentinelResource(
//            value = "fallback",
//            fallback = "handlerFallback",   //只负责java的运行时异常
//            blockHandler = "blockHandler", //只负责sentinel拦截的配置异常
//            exceptionsToIgnore = IllegalArgumentException.class
//    )
//    public CommonResult<PaymentEntity> fallback(@PathVariable Long id) {
//        CommonResult<PaymentEntity> result = restTemplate.getForObject(SERVICE_URL + "/PaymentEntitySql/" + id, CommonResult.class);
//        if (id == 4) {
//            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
//        } else if (result.getData() == null) {
//            throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常");
//        }
//        return result;
//    }

    @GetMapping("/openFeign/paymentSql/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockedHandler",exceptionsToIgnore =IllegalArgumentException.class )
    public CommonResult<PaymentEntity> paymentSql(@PathVariable("id") Long id) {
        return paymentService.paymentSql(id);
    }

    //
    public CommonResult<PaymentEntity> handlerFallback(@PathVariable Long id, Throwable e) {
        PaymentEntity payment = new PaymentEntity(id, null);
        return new CommonResult<>(444, "兜底异常handlerFallback,exception内容" + e.getMessage(), payment);
    }

    public CommonResult<PaymentEntity> blockHandler(@PathVariable Long id, BlockException blockException) {
        PaymentEntity payment = new PaymentEntity(id, null);
        return new CommonResult<>(445, "blockedHandler-sentinel限流,无此流水：blockException" + blockException.getMessage(), payment);
    }
}