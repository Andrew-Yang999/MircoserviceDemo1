package com.andrew.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.andrew.entity.CommonResult;

/**
 * @Author Andrew Yang
 * @ClassName CustomerBlockHandler
 * @Description
 * @Package com.andrew.handler
 * @Create 2021-08-11 09:14
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(400, exception.getClass().getCanonicalName() + "\t按客户自定义，global handler exception-1");
    }
    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(400, exception.getClass().getCanonicalName() + "\t按客户自定义，global handler exception-2");
    }
}
