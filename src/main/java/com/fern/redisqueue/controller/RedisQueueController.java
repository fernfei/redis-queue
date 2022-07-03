package com.fern.redisqueue.controller;

import com.fern.redisqueue.receive.ReceiveMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisQueueController {

    private final ReceiveMessageService receiveMessageService;

    public RedisQueueController(ReceiveMessageService receiveMessageService) {
        this.receiveMessageService = receiveMessageService;
    }

    @GetMapping("/receive")
    public String receive() {
        return receiveMessageService.receive("redis::queue::key");
    }
}
