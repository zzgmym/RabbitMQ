package com.example.demo3.RabbitMQ.delayedQueue.Ttl;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;



@EnableRabbit
@Configuration
public class ImmediateReceiver {

    @RabbitListener(queues = "immediateQueue")
    @RabbitHandler
    public void get(Booking booking) {
        System.out.println("收到延时消息了" + booking);
    }
}