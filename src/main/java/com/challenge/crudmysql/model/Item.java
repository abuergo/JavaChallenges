package com.challenge.crudmysql.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="items")
@Data
public class Item {
    @Id
    private Long id;
    private String name;
    private String category;
    private Long stock;
}
