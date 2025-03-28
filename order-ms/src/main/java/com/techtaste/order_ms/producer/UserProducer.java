package com.techtaste.order_ms.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.techtaste.order_ms.dto.MessageDTO;

@Component
public class UserProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.message.user}")
    private String queue;

    public void sendEmail(MessageDTO message) {
        rabbitTemplate.convertAndSend(queue, message);
        System.out.println(message);
    }
    
}
