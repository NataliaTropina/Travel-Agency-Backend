package com.example.travelagencybackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Rating {

    @Id
    private String id;
    @EqualsAndHashCode.Exclude
    private int value;
    @EqualsAndHashCode.Exclude
    private Destination destination;
    @EqualsAndHashCode.Exclude
    private User user;
}
