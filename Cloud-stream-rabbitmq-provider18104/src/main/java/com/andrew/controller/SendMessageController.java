package com.andrew.controller;

import com.andrew.service.IMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Andrew Yang
 * @ClassName SendMessageController
 * @Description
 * @Package com.andrew.controller
 * @Create 2021-08-08 20:58
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageService messageService;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        return messageService.send();
    }


}
