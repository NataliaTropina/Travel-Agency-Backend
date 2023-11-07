package com.example.travelagencybackend.services;

import com.example.travelagencybackend.dto.NewRatingDto;
import com.example.travelagencybackend.dto.RatingDto;

public interface RatingsService {

    RatingDto createRating (NewRatingDto newRating, int value, String DestinationId);
}
