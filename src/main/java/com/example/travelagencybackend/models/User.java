package com.example.travelagencybackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    public enum Role {
        USER, ADMIN
    }

    @Id
    private String id;
    @EqualsAndHashCode.Exclude
    private String firstName;
    @EqualsAndHashCode.Exclude
    private String lastName;
    @EqualsAndHashCode.Exclude
    private LocalDate createdDate;
    @EqualsAndHashCode.Exclude
    private String email;
    @EqualsAndHashCode.Exclude
    private List<Comment> comments;
    @EqualsAndHashCode.Exclude
    private List<Booking> bookings;
    @EqualsAndHashCode.Exclude
    private Role role;
    @EqualsAndHashCode.Exclude
    private String hashPassword;
}
