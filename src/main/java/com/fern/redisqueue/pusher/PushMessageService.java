package com.fern.redisqueue.pusher;

import com.fern.redisqueue.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author hufei
 */
@Component
public class PushMessageService {

    private final RedisUtils redisUtils;

    public PushMessageService(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }


    @PostConstruct
    public void init() throws InterruptedException {
        //创建新线程
        new Thread(() -> {
            int i = 0;
            while (true) {
                redisUtils.leftPush("redis::queue::key", "redis::queue::value::" + (++i));
                System.out.println("redis::queue::key<==> " + "redis::queue::value::" + i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
