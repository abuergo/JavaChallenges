package com.coderhouse.challenge.service;

import com.coderhouse.challenge.model.database.document.request.UserRequest;
import com.coderhouse.challenge.model.database.document.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest request);
    UserResponse update(String id, UserRequest request);
    UserResponse findById(String id);
    List<UserResponse> getUsers();
}
