package com.example.Async_Proj.controller;

import com.example.Async_Proj.entity.CustomUserDetails;
import com.example.Async_Proj.entity.UserDetailsResponse;
import com.example.Async_Proj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/us")
    public String getUserDetails(@RequestParam String name) throws InterruptedException {

        userService.getUserDetails(name);
        return "Getting User Details";
    }
}
