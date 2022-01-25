package com.challenge.mongodbandspringboot.controller;

import com.challenge.mongodbandspringboot.model.Product;
import com.challenge.mongodbandspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return service.createProduct(product);
    }

    @GetMapping("/all")
    public List<Product> findAll(){
        return service.findAll();
    }

    @GetMapping("/name/{name}")
    public Product findByName(@PathVariable String name){
        return service.findByName(name);
    }

    @GetMapping("/{price}")
    public List<Product> findByPriceGreaterThan(@PathVariable Integer price){
        return service.findByPriceGreaterThan(price);
    }

    @GetMapping()
    public List<Product> findAllByCategoriesSortedByAge(
            @RequestParam String category,
            @RequestParam String orderBy,
            @RequestParam int limit) {
        return service.findAllByCategoriesSortedLimit(category, orderBy, limit);
    }
}
