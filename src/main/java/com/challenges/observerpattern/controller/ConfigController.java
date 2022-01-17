package com.challenges.observerpattern.controller;

import com.challenges.observerpattern.model.UserConfig;
import com.challenges.observerpattern.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/config")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @PutMapping("/users")
    UserConfig updateConfig(@RequestBody UserConfig userConfig){
        configService.updateUserConfig(userConfig.getRol(), userConfig.getEmail(), userConfig.getPhone());
        return userConfig;
    }


}
