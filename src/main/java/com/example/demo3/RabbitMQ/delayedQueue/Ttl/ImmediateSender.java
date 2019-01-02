package com.example.demo3.RabbitMQ.delayedQueue.Ttl;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;



public class ImmediateSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 15000, initialDelay = 500)
    public void send() {
        int delayTime=1000;
        Booking booking = new Booking();
        booking.setBookingContent("hhaha");
        booking.setBookingName("预定房子");
        booking.setBookingTime(new Date());
        booking.setOperatorName("hellen");
        System.out.println("delayTime" + delayTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.rabbitTemplate.convertAndSend("DeadLetterExchange", "delay", booking, message -> {
            message.getMessageProperties().setExpiration(delayTime + "");
            System.out.println(sdf.format(new Date()) + " Delay sent.");
            return message;
        });
    }
}