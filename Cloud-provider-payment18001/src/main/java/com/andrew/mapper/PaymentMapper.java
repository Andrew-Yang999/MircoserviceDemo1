package com.andrew.mapper;

import com.andrew.entity.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Andrew Yang
 * @ClassName PaymentMapper
 * @Description
 * @Package com.andrew.mapper
 * @Create 2021-08-03 15:23
 */
@Mapper
public interface PaymentMapper {
    public int create(PaymentEntity paymentEntity);

    public PaymentEntity select(@Param("id") Long id);
}
