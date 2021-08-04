package com.andrew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Andrew Yang
 * @ClassName PaymentEntity
 * @Description
 * @Package com.andrew.entity
 * @Create 2021-08-03 15:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    private Long id;
    private String serial;
}
