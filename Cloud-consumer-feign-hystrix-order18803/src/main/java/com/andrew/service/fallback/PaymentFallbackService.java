package com.andrew.service.fallback;

import com.andrew.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author Andrew Yang
 * @ClassName PaymentFallbackService
 * @Description
 * @Package com.andrew.service.fallback
 * @Create 2021-08-06 10:43
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_timeOut";
    }
}
