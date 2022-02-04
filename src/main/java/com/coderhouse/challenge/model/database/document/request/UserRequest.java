package com.coderhouse.challenge.model.database.document.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// Here we validate user requested
public class UserRequest {

    @NotBlank(message = "User type is required")
    @Pattern(regexp = "^(ADMIN|CLIENT|EDITOR)$", message = "Type must be ADMIN, CLIENT or EDITOR")
    private String type;
    private String name;
}
