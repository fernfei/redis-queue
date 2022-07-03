package com.fern.redisqueue.receive;

import com.fern.redisqueue.utils.RedisUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author hufei
 */
@Component
public class ReceiveMessageService {

    private final RedisUtils redisUtils;

    public ReceiveMessageService(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    public String receive(String key) {
        return redisUtils.rightPopAndGet(key, 10, TimeUnit.SECONDS);
    }
}
