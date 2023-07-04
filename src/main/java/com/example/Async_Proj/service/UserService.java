package com.example.Async_Proj.service;

import com.example.Async_Proj.controller.UserController;
import com.example.Async_Proj.entity.CustomUserDetails;
import com.example.Async_Proj.entity.UserDetailsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    Logger log = LoggerFactory.getLogger(UserService.class);

    private String url = "https://api.github.com/users/";

    @Async
    public CustomUserDetails getUserDetails(String name) throws InterruptedException {

        CustomUserDetails customUserDetails = new CustomUserDetails();
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url+name);

        // Add query parameters
        uriBuilder.queryParam("name", name);

        // Build the final URL with query parameters
        String urlWithParams = uriBuilder.toUriString();

        UserDetailsResponse userDetailsResponse = restTemplate.getForObject(urlWithParams, UserDetailsResponse.class);

        customUserDetails.setLogin(userDetailsResponse.getLogin());
        customUserDetails.setId(userDetailsResponse.getId());
        customUserDetails.setType(userDetailsResponse.getType());
        customUserDetails.setSite_admin(userDetailsResponse.isSite_admin());

        Thread.sleep(5000);
        log.info(customUserDetails.toString());
        return customUserDetails;
    }
}
