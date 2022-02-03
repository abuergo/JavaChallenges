package com.coderhouse.challenge.service;

import com.coderhouse.challenge.model.User;
import com.coderhouse.challenge.model.UserFactory;
import lombok.RequiredArgsConstructor;
import com.coderhouse.challenge.repository.UserMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserMongoRepository userMongoRepository;

    private final UserFactory userFactory = new UserFactory();

    public User createUser(User user){
        log.info("An user is created");
        User userCreated = userFactory.createUser(user.getName(), user.getType());
        if(userCreated == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is not valid");
        }
        return userMongoRepository.save(userCreated, "usuarios");
    }











}
