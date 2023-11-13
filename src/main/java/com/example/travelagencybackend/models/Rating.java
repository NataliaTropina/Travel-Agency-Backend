package com.example.travelagencybackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Rating {

    @Id
    private String id;

    private int value;
    @DBRef
    private Destination destination;

    private User user;
}
