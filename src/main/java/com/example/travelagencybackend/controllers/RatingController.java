package com.example.travelagencybackend.controllers;

import com.example.travelagencybackend.controllers.api.RatingsApi;
import com.example.travelagencybackend.dto.NewRatingDto;
import com.example.travelagencybackend.dto.RatingDto;
import com.example.travelagencybackend.services.RatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RatingController implements RatingsApi {

    private final RatingsService ratingsService;

    @Override
    public ResponseEntity<RatingDto> createRating(NewRatingDto newRatingDto, int value, String destinationId) {
        return ResponseEntity.status(201).body(ratingsService.createRating(newRatingDto, value, destinationId));
    }
}
