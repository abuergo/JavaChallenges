package com.coderhouse.challenge.builder;

import com.coderhouse.challenge.model.database.document.UserDocument;
import com.coderhouse.challenge.model.database.document.concrete.UserAdmin;
import com.coderhouse.challenge.model.database.document.concrete.UserClient;
import com.coderhouse.challenge.model.database.document.concrete.UserEditor;
import com.coderhouse.challenge.model.database.document.request.UserRequest;
import com.coderhouse.challenge.model.database.document.response.UserResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBuilder {

    public static UserAdmin requestToEntityAdmin(UserRequest userRequest){
        return UserAdmin.builder()
                .type(userRequest.getType())
                .name(userRequest.getName())
                .type(userRequest.getType())
                .creationDate(new Date())
                .modificationDate(new Date())
                .build();
    }


    public static UserClient requestToEntityClient(UserRequest userRequest){
        return UserClient.builder()
                .type(userRequest.getType())
                .name(userRequest.getName())
                .type(userRequest.getType())
                .creationDate(new Date())
                .modificationDate(new Date())
                .build();
    }

    public static UserEditor requestToEntityEditor(UserRequest userRequest){
        return UserEditor.builder().type(userRequest.getType()).name(userRequest.getName()).type(userRequest.getType()).creationDate(new Date()).modificationDate(new Date()).build();

    }

    public static UserResponse createEntityToResponse(UserDocument entity){
        return UserResponse.builder().code(entity.getId()).createDate(entity.getCreationDate()).build();
    }

    public static <T extends UserDocument> UserResponse entityToResponse(T entity){
        if(entity instanceof UserAdmin){
            return UserResponse.builder().code(entity.getId())
                    .createDate(entity.getCreationDate())
                    .updateDate(entity.getModificationDate())
                    .type(entity.getType())
                    .name(entity.getName())
                    .build();
        } else if(entity instanceof UserClient){
            return UserResponse.builder().code(entity.getId())
                    .createDate(entity.getCreationDate())
                    .updateDate(entity.getModificationDate())
                    .type(entity.getType())
                    .name(entity.getName())
                    .build();
        } else{
            return UserResponse.builder().code(entity.getId())
                    .createDate(entity.getCreationDate())
                    .updateDate(entity.getModificationDate())
                    .type(entity.getType())
                    .name(entity.getName())
                    .build();
        }
    }

    public static <T extends UserDocument> List<UserResponse> listEntityToResponse(List<T> users){
        var responseList = new ArrayList<UserResponse>();
        users.forEach(item -> responseList.add(entityToResponse(item)));
        return responseList;
    }
}
