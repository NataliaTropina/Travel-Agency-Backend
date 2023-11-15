package com.example.travelagencybackend.services;

import com.example.travelagencybackend.dto.CommentDto;
import com.example.travelagencybackend.dto.CommentsPage;
import com.example.travelagencybackend.dto.NewCommentDto;
import com.example.travelagencybackend.security.details.AuthenticatedUser;

public interface CommentsService {

    CommentDto createComment(NewCommentDto newComment, AuthenticatedUser currentUser, String destinationId);

    CommentsPage getMyComments(AuthenticatedUser currentUser);

    CommentsPage findAll();

    CommentDto updateComment(String commentId, NewCommentDto newComment, AuthenticatedUser currentUserString);

    CommentDto deleteComment(String commentId);
}
