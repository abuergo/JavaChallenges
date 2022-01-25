package com.challenge.mongodbandspringboot.repository;

import com.challenge.mongodbandspringboot.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    Product findByName(String name);
    List<Product> findByPriceGreaterThan(Integer price);
}
