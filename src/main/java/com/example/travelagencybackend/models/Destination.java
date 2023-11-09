package com.example.travelagencybackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
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
    @EqualsAndHashCode.Exclude
    private String city;
    @EqualsAndHashCode.Exclude
    private String description;
    @EqualsAndHashCode.Exclude
    private String imageUrl;
    @EqualsAndHashCode.Exclude
    private double price;
    @EqualsAndHashCode.Exclude
    private List<Comment> comments;
    @EqualsAndHashCode.Exclude
    private Rating rating;
}
