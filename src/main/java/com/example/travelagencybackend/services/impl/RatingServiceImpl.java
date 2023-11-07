package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.NewRatingDto;
import com.example.travelagencybackend.dto.RatingDto;
import com.example.travelagencybackend.models.Rating;
import com.example.travelagencybackend.repositories.RatingsRepository;
import com.example.travelagencybackend.services.RatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingsService {

    private final RatingsRepository ratingsRepository;

    @Override
    public RatingDto createRating(NewRatingDto newRating, int value, String DestinationId) {



        //Rating existingRating = ratingsRepository.findByDestination(destination);

        return null;
    }
}
