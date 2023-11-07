package com.example.travelagencybackend.dto;

import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.models.Rating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDto {

    private String id;
    private int value;
    private String destinationId;


    public static RatingDto from (Rating rating){

        return RatingDto.builder()
                .value(rating.getValue())
                .destinationId(rating.getDestination().getId())
                .build();
    }

    public static List<RatingDto> from (List<Rating> ratings){

       return ratings.stream().map(RatingDto::from).collect(Collectors.toList());
    }
}
