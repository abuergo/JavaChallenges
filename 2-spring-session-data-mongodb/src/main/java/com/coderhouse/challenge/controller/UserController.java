package com.coderhouse.challenge.controller;

import com.coderhouse.challenge.model.database.document.request.UserRequest;
import com.coderhouse.challenge.model.database.document.response.UserResponse;
import com.coderhouse.challenge.service.impl.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImplementation service;

    @PostMapping
    private UserResponse createUser(@RequestBody @Validated UserRequest user){
        return service.create(user);
    }

    @GetMapping("/{id}")
    private UserResponse getUserById(@PathVariable String id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    private UserResponse updateUser(@PathVariable String id, @RequestBody @Validated UserRequest user){
        return service.update(id, user);
    }

    @GetMapping
    public List<UserResponse> getUsers(HttpSession session){
        session.setAttribute("test", "prueba");
        return service.getUsers();
    }

}

