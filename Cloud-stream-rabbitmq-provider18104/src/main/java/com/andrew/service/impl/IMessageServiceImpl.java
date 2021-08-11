package com.andrew.service.impl;

import com.andrew.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @Author Andrew Yang
 * @ClassName IMessageServiceImpl
 * @Description
 * @Package com.andrew.service.impl
 * @Create 2021-08-08 20:53
 */
@EnableBinding(Source.class)
public class IMessageServiceImpl implements IMessageService {
    @Autowired
    private MessageChannel output;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial***********" + serial);
        return serial;
    }
}
