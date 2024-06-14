package com.example.air.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    @Async
    public void sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setFrom("bensalahmayssa417@gmail.com");
        message.setSubject("Air Quality Alert");
        message.setText("The gas level has exceeded the threshold. Current level:");
        sender.send(message);
    }
}
