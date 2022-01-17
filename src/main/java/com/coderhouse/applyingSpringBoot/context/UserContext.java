package com.coderhouse.applyingSpringBoot.context;

import com.coderhouse.applyingSpringBoot.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserContext {

    @Bean
    public User getUser(){
        return new User();
    }
}
