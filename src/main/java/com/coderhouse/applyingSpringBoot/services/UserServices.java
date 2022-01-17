package com.coderhouse.applyingSpringBoot.services;

import com.coderhouse.applyingSpringBoot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private ApplicationContext context;

    public User getUser(){
        return (User) context.getBean("getUser");
    }

}
