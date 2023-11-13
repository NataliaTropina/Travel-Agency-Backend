package com.example.travelagencybackend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String firstName;
    private String lastName;
    private LocalDate createdDate;
    private String email;
    private List<Comment> comments;
    private List<Booking> bookings;
    private Role role;
    private String hashPassword;
}
