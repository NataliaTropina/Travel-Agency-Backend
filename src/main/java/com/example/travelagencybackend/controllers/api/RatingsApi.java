package com.example.travelagencybackend.controllers.api;

import com.example.travelagencybackend.dto.BookingDto;
import com.example.travelagencybackend.dto.NewRatingDto;
import com.example.travelagencybackend.dto.RatingDto;
import com.example.travelagencybackend.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tags(value = {
        @Tag(name = "Bookings")
})
@RequestMapping("/api/ratings")
public interface RatingsApi {

    @Operation(summary = "Create rating")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create new rating, or set old rating",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RatingDto.class))
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Validation Error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
                    })
    })
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    ResponseEntity<RatingDto> createRating (NewRatingDto newRatingDto, int value, String destinationId);

}
