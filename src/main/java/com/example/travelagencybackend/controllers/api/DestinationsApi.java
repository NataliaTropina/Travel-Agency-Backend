package com.example.travelagencybackend.controllers.api;

import com.example.travelagencybackend.dto.DestinationDto;
import com.example.travelagencybackend.dto.DestinationsPage;
import com.example.travelagencybackend.dto.NewDestinationDto;
import com.example.travelagencybackend.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
        @Tag(name = "Destinations")
})
@RequestMapping("/api/destinations")
public interface DestinationsApi {

    @Operation(summary = "Create a new destination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create a new destination",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DestinationDto.class))
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Validation Error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
                    })
    })
    @PostMapping
    ResponseEntity<DestinationDto> createDestination(@RequestBody NewDestinationDto newDestination);


    @Operation(summary = "Get all destinations", description = "Available to everyone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of destinations",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DestinationDto.class))
                    }
            ),
            @ApiResponse(responseCode = "401", description = "Destinations not found!!!",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            ),
            @ApiResponse(responseCode = "404", description = "This is not the web page you are looking for.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            )
    })

    @GetMapping
    DestinationsPage findAll();

    @Operation(summary = "Get a destinations by city ", description = "Available to everyone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination finded",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DestinationDto.class))
                    }
            ),
            @ApiResponse(responseCode = "401", description = "Destination not found!!!",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            )
    })

    @GetMapping(value = "/by/{city}")
    DestinationsPage findByCity(@PathVariable String city);
}
