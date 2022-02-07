package com.coderhouse.challenge.repository;
import com.coderhouse.challenge.model.database.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserDocument, String> {

}


