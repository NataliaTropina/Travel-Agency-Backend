package com.example.travelagencybackend.repositories;

import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.models.Rating;
import com.example.travelagencybackend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingsRepository extends MongoRepository<Rating, String> {


    Rating findByDestination(Destination destination);

    List<Rating> findAllByUser(User user);

    Rating findAllByUserAndId (User user, String ratingId);
}
