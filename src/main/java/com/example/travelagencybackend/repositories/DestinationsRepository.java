package com.example.travelagencybackend.repositories;

import com.example.travelagencybackend.models.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DestinationsRepository extends MongoRepository<Destination, String> {

    List<Destination> findAll();

    List<Destination> findByCity(String str);
}
