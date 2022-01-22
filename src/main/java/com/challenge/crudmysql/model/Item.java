package com.challenge.crudmysql.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private Long stock;
}
