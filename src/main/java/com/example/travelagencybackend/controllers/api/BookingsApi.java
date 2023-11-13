package com.example.travelagencybackend.controllers.api;

import com.example.travelagencybackend.dto.BookingDto;
import com.example.travelagencybackend.dto.BookingsPage;
import com.example.travelagencybackend.dto.NewBookingDto;
import com.example.travelagencybackend.dto.UserDto;
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
        @Tag(name = "Bookings")
})
@RequestMapping("/api/bookings")
public interface BookingsApi {


    @Operation(summary = "Create booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create new booking",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BookingDto.class))
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Validation Error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
                    })
    })
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    ResponseEntity<BookingDto> createBooking (@RequestBody NewBookingDto newBooking,
                                              @Parameter(hidden = true)
                                              @AuthenticationPrincipal AuthenticatedUser currentUser);


    @Operation(summary = "Bookings page by user", description = "available only to authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "page with bookings",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BookingsPage.class))
                    }
            )
    })

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/by-user")
    BookingsPage getMyBookings (@Parameter(hidden = true)
                                @AuthenticationPrincipal AuthenticatedUser currentUser);


    @Operation(summary = "Update Booking by id", description = "available only to authenticated user")
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
    ResponseEntity<BookingDto> updateBooking (@PathVariable("id") String bookingId,
                                              @RequestBody NewBookingDto newBooking,
                                              @Parameter(hidden = true)
                                              @AuthenticationPrincipal AuthenticatedUser currentUser);

    @Operation(summary = "Delete Booking by id", description = "available only to authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete Booking",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BookingDto.class))
                    }
            )
    })
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    ResponseEntity<BookingDto> deleteBooking(@Parameter(hidden = true)
                                             @AuthenticationPrincipal AuthenticatedUser currentUser,
                                             @PathVariable("id") String bookingId);


}
