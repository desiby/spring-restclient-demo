package com.example.restclientdemo.client.service;

import com.example.restclientdemo.client.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RestClient {

    public final String GET_ALL_URL = "http://localhost:8080/api/all";
    public final String POST_URL = "http://localhost:8080/api/user";
    private static final String DEL_N_PUT_URL = "http://localhost:8080/api/";



    private static RestTemplate restTemplate = new RestTemplate();


    //get all users
    public List<User> getAllUsers() {
        return Arrays.stream(restTemplate.getForObject(GET_ALL_URL, User[].class)).collect(Collectors.toList());
    }

    //create user
    public User postUser(User user) {
        return restTemplate.postForObject(POST_URL, user, User.class);
    }

    //delete user
    public void delete(Long id){
        restTemplate.delete(DEL_N_PUT_URL+id);
    }

    //update user
    public User update(Long id, User user){
        return restTemplate.exchange(DEL_N_PUT_URL+id, HttpMethod.PUT,
                new HttpEntity<>(user), User.class, id).getBody();

    }



}
