package com.example.demo3.RabbitMQ.tut6;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Tut6Server {

    @RabbitListener(queues = "tut.rpc.requests")
    // @SendTo("tut.rpc.replies") used when the
    // client doesn't set replyTo.
    public byte[] fibonacci(int n) throws Exception {
        System.out.println(" [x] Received request for " + n);
        byte[] bytes = fib(n);
        System.out.println(" [.] Returned " + bytes);
        return bytes;
    }

    public byte[] fib(int n) throws Exception {
        return getBytesFromObject(new User(n));
//        return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }
    //对象转字节码
    public  byte[] getBytesFromObject(Serializable obj) throws Exception {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        return bo.toByteArray();
    }
}