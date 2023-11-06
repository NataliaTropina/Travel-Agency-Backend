package com.example.travelagencybackend.dto;

import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.models.User;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class CommentDto {


    @Id
    private String id;
    private LocalDate createdDate;
    private String description;
    private String userId;
    private Destination destination;

}
