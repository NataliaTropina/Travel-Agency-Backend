package com.example.travelagencybackend.dto;

import com.example.travelagencybackend.models.Destination;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Existing destination")
public class DestinationDto {

    @Schema(description = "destination identifier", example = "1")
    private String id;
    private String city;
    private String description;
    private String imageUrl;
    private double price;

    public static DestinationDto from(Destination destination) {
        return DestinationDto.builder()
                .id(destination.getId())
                .city(destination.getCity())
                .description(destination.getDescription())
                .imageUrl(destination.getImageUrl())
                .price(destination.getPrice())
                .build();
    }

    public static List<DestinationDto> from(List<Destination> destinations) {
        return destinations.stream()
                .map(DestinationDto::from)
                .collect(Collectors.toList());
    }
}
