package com.challenge.mongodbandspringboot.service;

import com.challenge.mongodbandspringboot.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product findByName(String name);
    List<Product> findAll();
    List<Product> findByPriceGreaterThan(Integer price);
    List<Product> findAllByCategoriesSortedLimit(String category, String orderBy, Integer limit);
}
