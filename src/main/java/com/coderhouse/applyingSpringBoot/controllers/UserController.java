package com.coderhouse.applyingSpringBoot.controllers;

import com.coderhouse.applyingSpringBoot.handle.ApiRestException;
import com.coderhouse.applyingSpringBoot.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userService;

    @GetMapping
    public String getUserName() throws ApiRestException{
        String userName = userService.getUser().getName();
        if(userName == null){
            throw new ApiRestException("User has no name");
        }
        return userName;
    }

    @PostMapping
    public String setUser(@RequestParam String name){
        userService.getUser().setName(name);
        return name + " user was set correctly";
    }
}
