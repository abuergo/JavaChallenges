package com.coderhouse.challenge.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class UserFactory {
    public User createUser(String name, String type){
        switch (type){
            case "ADMIN":
                return new Admin(name,type);
            case "EDITOR":
                return new Editor(name, type);
            case "CLIENT":
                return new Client(name, type);
            default:
                return null;
        }
    }
}
