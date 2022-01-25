package com.challenge.mongodbandspringboot.service;

import com.challenge.mongodbandspringboot.model.Product;
import com.challenge.mongodbandspringboot.repository.ProductRepository;
import com.challenge.mongodbandspringboot.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductRepositoryImpl template;

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByPriceGreaterThan(Integer price) {
        return repository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findAllByCategoriesSortedLimit(String category, String orderBy, Integer limit) {
        return template.findAllByCategoriesSortedLimit(category,orderBy,limit);
    }
}
