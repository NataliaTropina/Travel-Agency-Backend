package com.example.travelagencybackend.repositories;

import com.example.travelagencybackend.models.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DestinationsRepository extends MongoRepository<Destination, String> {
}
