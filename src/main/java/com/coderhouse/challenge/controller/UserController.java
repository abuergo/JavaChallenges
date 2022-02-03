package com.coderhouse.challenge.controller;

import com.coderhouse.challenge.model.User;
import com.coderhouse.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    private User createUser(@RequestBody User user){
        return service.createUser(user);
    }


}
