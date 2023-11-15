package com.example.travelagencybackend.controllers.api;

import com.example.travelagencybackend.dto.BookingDto;
import com.example.travelagencybackend.dto.NewRatingDto;
import com.example.travelagencybackend.dto.RatingDto;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
        @Tag(name = "Ratings")
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
    ResponseEntity<RatingDto> createRating(@Parameter(hidden = true)
                                           @AuthenticationPrincipal AuthenticatedUser currentUser,
                                           @RequestBody NewRatingDto newRatingDto, String destinationId);


    @Operation(summary = "Update Rating by id", description = "available only to authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update Booking",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BookingDto.class))
                    }
            )
    })

    @PreAuthorize("isAuthenticated()")
    @PutMapping(value = "/{id}")
    ResponseEntity<RatingDto> updateRatingById(@RequestBody NewRatingDto newRating,
                                               @PathVariable("id") String ratingId,
                                               @Parameter(hidden = true)
                                               @AuthenticationPrincipal AuthenticatedUser currentUser);


    @Operation(summary = "Delete Rating by id", description = "available only to authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete Rating",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BookingDto.class))
                    }
            )
    })
    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<RatingDto> deleteRating(@Parameter(hidden = true)
                                           @AuthenticationPrincipal AuthenticatedUser currentUser,
                                           @PathVariable("id") String id);
}
