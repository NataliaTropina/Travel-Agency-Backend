package com.example.travelagencybackend.controllers;

import com.example.travelagencybackend.controllers.api.RatingsApi;
import com.example.travelagencybackend.dto.NewRatingDto;
import com.example.travelagencybackend.dto.RatingDto;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.services.RatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RatingController implements RatingsApi {

    private final RatingsService ratingsService;


    @Override
    public ResponseEntity<RatingDto> createRating(AuthenticatedUser currentUser, NewRatingDto newRating, String destinationId) {
        return ResponseEntity.status(201).body(ratingsService.createRating(currentUser, newRating, destinationId));
    }

    @Override
    public ResponseEntity<RatingDto> updateRatingById(NewRatingDto newRating, String ratingId, AuthenticatedUser currentUser) {
        return ResponseEntity.ok(ratingsService.updateRating(newRating, ratingId, currentUser));
    }

    @Override
    public ResponseEntity<RatingDto> deleteRating(AuthenticatedUser currentUser, String id) {
        return ResponseEntity.ok(ratingsService.deleteRating(currentUser, id));
    }
}
