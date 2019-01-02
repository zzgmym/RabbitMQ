package com.example.demo3.RabbitMQ.delayedQueue.XDM;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 15000, initialDelay = 500)
    public void sendMsg() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:"+sdf.format(new Date()));
        rabbitTemplate.convertAndSend("test_exchange", "test_queue_1", "Hello I am a message", message -> {
            message.getMessageProperties().setHeader("x-delay",3000);
            return message;
        });
    }
}