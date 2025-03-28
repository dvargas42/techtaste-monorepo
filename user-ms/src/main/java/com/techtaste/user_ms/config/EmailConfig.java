package com.techtaste.user_ms.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techtaste.user_ms.dto.EmailDTO;
import com.techtaste.user_ms.service.UserService;

@Configuration
public class EmailConfig {
    
    @Autowired
    private UserService service;

    @Value("queue.message.user")
    private String queue;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @RabbitListener(queues = "queue.message.user")
    private void sendEmail(@Payload EmailDTO message) {
        System.out.println(message);
        service.sendMessage(message);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
