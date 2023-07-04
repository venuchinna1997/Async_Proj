package com.example.Async_Proj.service;

import com.example.Async_Proj.UserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://api.github.com/users/";

    public UserDetailsResponse getUserDetails(String name) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url+name);

        // Add query parameters
        uriBuilder.queryParam("name", name);

        // Build the final URL with query parameters
        String urlWithParams = uriBuilder.toUriString();

        UserDetailsResponse userDetailsResponse = restTemplate.getForObject(urlWithParams, UserDetailsResponse.class);
        return userDetailsResponse;
    }
}
