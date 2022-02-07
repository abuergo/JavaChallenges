package com.coderhouse.challenge.model.database.document.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private String code;
    private Date createDate;
    private Date updateDate;
    private String type;
    private String name;
}
