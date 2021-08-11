package com.andrew.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author Andrew Yang
 * @ClassName ReceiveMessageListenerController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-08 21:01
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("我是消费者1号，-----》接受到的消息是："+message.getPayload()+"\t"+serverPort);
    }

}
