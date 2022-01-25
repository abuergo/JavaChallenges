package com.challenge.mongodbandspringboot.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// con la anotacion document creamos una collection del nombre que le mandamos por parametro
@Document("product")
@Data
public class Product {
    @Id
    // We cannot use GeneratedValue annotation because that is a JPA annotation (only works with mysql)
    private Long id;
    private String name;
    private Integer price;
    private Long stock;

    public Product(Long id, String name, Integer price, Long stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product() {
    }
}
