package com.example.Async_Proj.controller;

import com.example.Async_Proj.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail() {
        // Trigger email sending asynchronously
        emailService.sendEmail("recipient@example.com", "Example Subject", "Example Body");

        return "Email sending initiated";
    }
}
