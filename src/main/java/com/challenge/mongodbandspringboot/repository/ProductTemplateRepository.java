package com.challenge.mongodbandspringboot.repository;

import com.challenge.mongodbandspringboot.model.Product;

import java.util.List;

public interface ProductTemplateRepository {


    List<Product> findAllByCategoriesSortedLimit(String category, String orderBy, Integer limit);


}
