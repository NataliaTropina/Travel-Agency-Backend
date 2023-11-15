package com.example.travelagencybackend.services;

import com.example.travelagencybackend.dto.NewRatingDto;
import com.example.travelagencybackend.dto.RatingDto;
import com.example.travelagencybackend.security.details.AuthenticatedUser;

public interface RatingsService {

    RatingDto createRating(AuthenticatedUser currentUser, NewRatingDto newRating, String DestinationId);

    RatingDto updateRating(NewRatingDto newRating, String ratingId, AuthenticatedUser currentUser);

    RatingDto deleteRating(AuthenticatedUser currentUser, String id);
}
