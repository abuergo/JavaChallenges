package com.coderhouse.challenge.model;

import com.coderhouse.challenge.builder.UserBuilder;
import com.coderhouse.challenge.model.database.document.UserDocument;
import com.coderhouse.challenge.model.database.document.request.UserRequest;
import lombok.Data;

@Data
public class UserFactory {
    public UserDocument createUser(UserRequest userRequest){
        switch (userRequest.getType()){
            case "ADMIN":
                return UserBuilder.requestToEntityAdmin(userRequest);
            case "EDITOR":
                return UserBuilder.requestToEntityEditor(userRequest);
            case "CLIENT":
                return UserBuilder.requestToEntityClient(userRequest);
            default:
                return null;
        }
    }
}
