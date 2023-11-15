package com.example.travelagencybackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
