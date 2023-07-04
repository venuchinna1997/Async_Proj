package com.example.Async_Proj.controller;

import com.example.Async_Proj.entity.CustomUserDetails;
import com.example.Async_Proj.entity.UserDetailsResponse;
import com.example.Async_Proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/us")
    public CustomUserDetails getUserDetails(@RequestParam String name){
        return userService.getUserDetails(name);
    }
}
