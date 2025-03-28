package com.techtaste.user_ms.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    
    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(from.trim());
        email.setSubject(subject);
        email.setTo(to.trim());
        email.setText(content);
        try {
            emailSender.send(email);
            logger.info("Message send with sucess to: " + to);
        } catch (Exception ex) {
            throw new RuntimeException("Error sending email", ex);
        }
    }
}
