package com.challenge.arrayProducts.controller;

import com.challenge.arrayProducts.handle.ProductError;
import com.challenge.arrayProducts.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> productList = new ArrayList<>();

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

    @PostMapping
    public String addProduct(@RequestBody Map<String,String> requestParam) {
        String title = requestParam.get("title");
        String price = requestParam.get("price");
        Product product = new Product(title, Integer.parseInt(price));
        productList.add(product);
        product.setId(productList.size());
        return "A new product was added with id: " + productList.size();
    }
}
