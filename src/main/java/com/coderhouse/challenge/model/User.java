package com.coderhouse.challenge.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Document("users")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String type;
    private Date creationDate;
    private Date modificationDate;

    public User(String name, String type){
        this.name = name;
        this.type = type;
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }
}
