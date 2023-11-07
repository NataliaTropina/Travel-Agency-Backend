package com.example.travelagencybackend.controllers;

import com.example.travelagencybackend.controllers.api.CommentsApi;
import com.example.travelagencybackend.dto.CommentDto;
import com.example.travelagencybackend.dto.CommentsPage;
import com.example.travelagencybackend.dto.NewCommentDto;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentsController implements CommentsApi {

    private final CommentsService commentsService;

    @Override
    public ResponseEntity<CommentDto> createComment(NewCommentDto newComment, AuthenticatedUser currentUser, String destinationId) {
        return ResponseEntity.status(201).body(commentsService.createComment(newComment, currentUser, destinationId));
    }

    @Override
    public CommentsPage getMyComments(String userId,AuthenticatedUser currentUser) {
        return commentsService.getMyComments(currentUser);
    }

    @Override
    public ResponseEntity<CommentDto> updateComment(String commentId, NewCommentDto newComment, AuthenticatedUser currentUser, String destinationId) {
        return ResponseEntity.ok(commentsService.updateComment(commentId, newComment, currentUser, destinationId));
    }

    @Override
    public ResponseEntity<CommentDto> deleteComment(String commentId) {
        return ResponseEntity.ok(commentsService.deleteComment(commentId));
    }

    @Override
    public CommentsPage findAll() {
        return commentsService.findAll();
    }
}
