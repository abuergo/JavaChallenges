package com.challenge.arrayProducts.controller;

import com.challenge.arrayProducts.handle.ProductError;
import com.challenge.arrayProducts.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    Logger log = LogManager.getLogger(ProductController.class);
    private final List<Product> productList = new ArrayList<>(){{
        add(new Product("Milk", 190, 0));
        add(new Product("Yogurt", 250, 1));
}};

    @GetMapping
    public List<Product> getProductList() throws ProductError{
        if(productList.isEmpty()){
            throw new ProductError("There are no products loaded");
        }
        return productList;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) throws ProductError{
        for(Product product : productList){
            if(product.getId() == id){
                return product;
            }
        }
        throw new ProductError("There are no products with that ID");
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        productList.add(product);
        log.info("Product added successfully");
        return product;
    }
}
