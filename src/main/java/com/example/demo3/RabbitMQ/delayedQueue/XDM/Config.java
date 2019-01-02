package com.example.demo3.RabbitMQ.delayedQueue.XDM;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Profile({"xdm"})
@Configuration
public class Config {

    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange("test_exchange", "x-delayed-message",true, false,args);
    }

    @Bean
    public Queue queue() {
        return new Queue("test_queue_1", true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(delayExchange()).with("test_queue_1").noargs();
    }
    @Bean
    public MessageReceiver receiver(){
        return new MessageReceiver();
    }
    @Bean
    public MessageSender sender(){
        return  new MessageSender();
    }
}