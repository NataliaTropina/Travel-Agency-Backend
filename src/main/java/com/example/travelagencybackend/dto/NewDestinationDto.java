package com.example.travelagencybackend.dto;

import com.example.travelagencybackend.models.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Create a new destination")

public class NewDestinationDto {

    private String city;
    private String description;
    private String imageUrl;
    private double price;
}
