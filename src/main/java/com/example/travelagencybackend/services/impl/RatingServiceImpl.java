package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.NewRatingDto;
import com.example.travelagencybackend.dto.RatingDto;
import com.example.travelagencybackend.exceptions.NotFoundException;
import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.models.Rating;
import com.example.travelagencybackend.repositories.DestinationsRepository;
import com.example.travelagencybackend.repositories.RatingsRepository;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.services.RatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingsService {

    private final RatingsRepository ratingsRepository;

    private final DestinationsRepository destinationsRepository;


    @Override
    public RatingDto createRating(AuthenticatedUser currentUser, NewRatingDto newRating,  String destinationId) {

        Destination destination = destinationsRepository.findById(destinationId)
                .orElseThrow(()->
                        new NotFoundException("Destination with id <" + destinationId + "> not found"));

        Rating existingRating = ratingsRepository.findByDestination(destination);

        if (existingRating == null){

            Rating rating = Rating.builder()
                    .value(newRating.getValue())
                    .destination(destination)
                    .build();
            ratingsRepository.save(rating);

            destination.setRating(rating);

            destinationsRepository.save(destination);

            return RatingDto.from(rating);

        } else {

            existingRating.setValue(existingRating.getValue() + newRating.getValue());
            ratingsRepository.save(existingRating);

            return RatingDto.from(existingRating);
        }
    }

    @Override
    public RatingDto updateRating(NewRatingDto newRating, String ratingId, AuthenticatedUser currentUser) {


        Rating rating = ratingsRepository.findById(ratingId)
                        .orElseThrow(()->
                                new NotFoundException("Rating with id <" + currentUser.getUser().getId() + "> not found"));

            rating.setValue(newRating.getValue());

            ratingsRepository.save(rating);


        return RatingDto.from(rating);
    }

    @Override
    public RatingDto deleteRating(AuthenticatedUser currentUser, String id) {


        Rating rating = ratingsRepository.findById(id)
                        .orElseThrow(()->
                                new NotFoundException("Rating with id <" + id + "> not found"));

        ratingsRepository.delete(rating);

        return RatingDto.from(rating);
    }
}
