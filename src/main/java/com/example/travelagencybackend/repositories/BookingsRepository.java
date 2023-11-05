package com.example.travelagencybackend.repositories;

import com.example.travelagencybackend.models.Booking;
import com.example.travelagencybackend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingsRepository extends MongoRepository<Booking, String> {

    List<Booking> findAllByUser (User user);
}
