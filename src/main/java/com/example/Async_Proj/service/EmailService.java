package com.example.Async_Proj.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Async
    public void sendEmail(String recipient, String subject, String body) {
        // Simulate sending email
        try {
            Thread.sleep(5000); // Wait for 5 seconds to simulate email sending
            System.out.println("Email sent to: " + recipient);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
