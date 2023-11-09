package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.*;
import com.example.travelagencybackend.exceptions.NotFoundException;
import com.example.travelagencybackend.models.Comment;
import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.models.User;
import com.example.travelagencybackend.repositories.CommentsRepository;
import com.example.travelagencybackend.repositories.DestinationsRepository;
import com.example.travelagencybackend.repositories.UsersRepository;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    private final UsersRepository usersRepository;

    private final DestinationsRepository destinationsRepository;

    @Override
   public CommentDto createComment(NewCommentDto newComment, AuthenticatedUser currentUser,String destinationId) {

       User user = usersRepository.findById(currentUser.getUser().getId())
               .orElseThrow(()->
                      new NotFoundException("User with id <" + currentUser.getUser().getId() + "> not found"));
       Destination destination = destinationsRepository.findById(destinationId)
               .orElseThrow(()->
                       new NotFoundException("Destination with id <" + destinationId + "> not found"));

           Comment comment = Comment.builder()
                   .createdDate(LocalDate.now())
                   .description(newComment.getDescription())
                   .user(user)
                   .destination(destination)
                   .build();

           commentsRepository.save(comment);

           return CommentDto.from(comment);
    }

    @Override
    public CommentsPage getMyComments(AuthenticatedUser currentUser) {

        User user = usersRepository.findById(currentUser.getUser().getId()).get();
           //     .orElseThrow(()->
            //            new NotFoundException("User with id <" + currentUser.getUser().getId() + "> not found"));

        List<Comment> commentsByUser = commentsRepository.findAllByUser(user);

        return CommentsPage.builder()
                .data(CommentDto.from(commentsByUser))
                .build();
    }

    @Override
    public CommentDto updateComment(String commentId, NewCommentDto newComment, AuthenticatedUser currentUser, String destinationId) {

        User user = usersRepository.findById(currentUser.getUser().getId()).get();
           //     .orElseThrow(() ->
            //            new NotFoundException("User with id <" + currentUser.getUser().getId() + "> not found"));
        Destination destination = destinationsRepository.findById(destinationId).get();

        List<Comment> commentsByUser = commentsRepository.findAllByUser(user);

        Comment commentToUpdate = null;

        for (Comment comment : commentsByUser) {
            if (comment.getId().equals(commentId)) {

                comment.setCreatedDate(newComment.getCreatedDate());
                comment.setDescription(newComment.getDescription());

                commentsRepository.save(comment);

                commentToUpdate = comment;
            }
        }
        if (commentToUpdate != null) {
            return CommentDto.from(commentToUpdate);

        }else {
       //     throw new NotFoundException("No comment found");
            return null;
        }
    }


    @Override
    public CommentDto deleteComment(String commentId) {

        Comment comment = commentsRepository.findById(commentId).get();
            //    .orElseThrow(()->
              //          new ChangeSetPersister.NotFoundException("Comment with id <" + commentId + "> not found")
               // );

        commentsRepository.deleteById(commentId);

        return CommentDto.from(comment);
    }

    @Override
    public CommentsPage findAll() {
        List<Comment> comments = commentsRepository.findAll();
        return CommentsPage
                .builder()
                .data(CommentDto.from(comments))
                .build();
    }
}
