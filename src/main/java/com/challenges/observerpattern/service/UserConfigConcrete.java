package com.challenges.observerpattern.service;

import com.challenges.observerpattern.utils.ConfigObserver;
import com.challenges.observerpattern.utils.ConfigType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class UserConfigConcrete implements InitializingBean, ConfigObserver {
    @Autowired
    ConfigSubject configSubject;

    @Autowired
    ConfigService configService;

    private String rol;
    private String email;
    private String phone;

    @Override
    public void updateConfig(Object event){
        if(event.equals(ConfigType.USER)){
            this.rol = configService.getUserRol();
            this.email = configService.getUserEmail();
            this.phone = configService.getUserPhone();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        configSubject.addObserver(this);
    }

}
