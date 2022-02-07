package com.coderhouse.challenge.service.impl;

import com.coderhouse.challenge.builder.UserBuilder;
import com.coderhouse.challenge.cache.CacheClient;
import com.coderhouse.challenge.model.UserFactory;
import com.coderhouse.challenge.model.database.document.UserDocument;
import com.coderhouse.challenge.model.database.document.request.UserRequest;
import com.coderhouse.challenge.model.database.document.response.UserResponse;
import com.coderhouse.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import com.coderhouse.challenge.repository.UserMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserMongoRepository userMongoRepository;
    private final UserFactory userFactory = new UserFactory();
    private final CacheClient<UserDocument> cache;

    @Override
    public UserResponse create(UserRequest request) {
        var entity = userFactory.createUser(request);
        var entitySaved = userMongoRepository.save(entity);
        saveUser(entity);
        return UserBuilder.createEntityToResponse(entity);
    }

    @Override
    public UserResponse update(String id, UserRequest request) {
        var entity=userFactory.createUser(request);
        entity.setId(id);
        entity.setModificationDate(new Date());
        var entitySaved =userMongoRepository.save(entity);
        saveUser(entity);
        return UserBuilder.createEntityToResponse(entitySaved);
    }

    private UserResponse saveUser(UserDocument user){
        var userSaved = cache.save(user.getId(), user);
        return UserBuilder.createEntityToResponse(userSaved);
    }

    @Override
    public UserResponse findById(String id) {
        Optional<UserDocument> optional = userMongoRepository.findById(id);
        return optional.map(UserBuilder::entityToResponse).orElse(null);
    }

    @Override
    public List<UserResponse> getUsers() {
        return UserBuilder.listEntityToResponse(userMongoRepository.findAll());
    }

}
