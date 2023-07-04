package com.example.Async_Proj.service;

import com.example.Async_Proj.entity.CustomUserDetails;
import com.example.Async_Proj.entity.UserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://api.github.com/users/";

    public CustomUserDetails getUserDetails(String name) {

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

        return customUserDetails;
    }
}
