package com.challenge.mongodbandspringboot.repository;

import com.challenge.mongodbandspringboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductTemplateRepository{

    @Autowired
    MongoTemplate template;

    @Override
    public List<Product> findAllByCategoriesSortedLimit(String category, String orderBy, Integer limit) {
        var query = new Query();
        query.with(Sort.by(
                orderBy.equalsIgnoreCase("DESC")
                ? Sort.Order.desc("precio")
                        : Sort.Order.asc("precio")
        ));
        query.limit(limit);
        query.addCriteria(Criteria.where("category").gt(category));

        return template.find(query, Product.class);
    }
}
