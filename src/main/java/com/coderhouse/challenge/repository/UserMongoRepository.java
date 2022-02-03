package com.coderhouse.challenge.repository;
import com.coderhouse.challenge.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserMongoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User save(User user, String collection){
        return mongoTemplate.save(user, collection);
    }

}


