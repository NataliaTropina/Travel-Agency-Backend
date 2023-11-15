package com.example.travelagencybackend.repositories;

import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingsRepository extends MongoRepository<Rating, String> {

    Rating findByDestination(Destination destination);

}
