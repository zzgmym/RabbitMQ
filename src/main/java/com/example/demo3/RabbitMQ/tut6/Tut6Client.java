package com.example.demo3.RabbitMQ.tut6;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;

public class Tut6Client {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange exchange;

    int start = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() throws Exception {
        System.out.println(" [x] Requesting fib(" + start + ")");
        byte[] bytes = (byte[]) template.convertSendAndReceive(exchange.getName(), "rpc", start++);
        User user=(User) getObjectFromBytes(bytes);
        System.out.println(" [.] Got '" + user + "'");
    }
    //字节码转对象
    public  Object getObjectFromBytes(byte[] objBytes) throws Exception {
        if (objBytes == null || objBytes.length == 0) {
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}