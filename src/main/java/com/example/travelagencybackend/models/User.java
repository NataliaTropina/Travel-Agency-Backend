package com.example.travelagencybackend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class User {

    public enum Role {
        USER, ADMIN
    }

    @Id
    private String id;

    private String email;
    private String hashPassword;

    private Role role;

}

