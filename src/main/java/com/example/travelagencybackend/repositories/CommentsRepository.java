package com.example.travelagencybackend.repositories;

import com.example.travelagencybackend.models.Comment;
import com.example.travelagencybackend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentsRepository extends MongoRepository<Comment, String> {

    List<Comment> findAll();

    List<Comment> findAllByUser(User user);
}
