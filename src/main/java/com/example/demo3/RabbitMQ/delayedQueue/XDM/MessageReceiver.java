package com.example.demo3.RabbitMQ.delayedQueue.XDM;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MessageReceiver {

    @RabbitListener(queues = "test_queue_1")
    public void receive(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息接收时间:"+sdf.format(new Date()));
        System.out.println("接收到的消息:"+msg);
    }
}