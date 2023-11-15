package com.example.travelagencybackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "destinations")
public class Destination {

    @Id
    private String id;
    private String city;
    private String description;
    private String imageUrl;
    private double price;
    @DBRef
    private List<Comment> comments;
    @DBRef
    private Rating rating;
}
