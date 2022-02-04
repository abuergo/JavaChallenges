package com.coderhouse.challenge.model.database.document;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("mongoUsers")
@SuperBuilder(toBuilder = true)
public class UserDocument {
    @Id
    private String id;
    private String name;
    private String type;
    private Date creationDate;
    private Date modificationDate;

}

