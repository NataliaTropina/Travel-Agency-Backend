package com.example.travelagencybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate createdDate;
    private String role;
}
