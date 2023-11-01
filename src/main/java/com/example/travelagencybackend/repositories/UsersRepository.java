package com.example.travelagencybackend.repositories;


import com.example.travelagencybackend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface UsersRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
    boolean existsById(String id);
}
