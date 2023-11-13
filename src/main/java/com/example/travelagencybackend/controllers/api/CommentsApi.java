package com.example.travelagencybackend.controllers.api;

import com.example.travelagencybackend.dto.*;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
        @Tag(name = "Comments")
})
@RequestMapping("/api/comments")
public interface CommentsApi {

    @Operation(summary = "Create comment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create a new comment",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CommentDto.class))
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Validation Error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
                    })
    })
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    ResponseEntity<CommentDto> createComment(@RequestBody NewCommentDto newComment,
                                             @Parameter(hidden = true)
                                             @AuthenticationPrincipal AuthenticatedUser currentUser,
                                             String destinationId);

    @Operation(summary = "Comments page by userId", description = "Available only to authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "page with comments",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CommentsPage.class))
                    }
            )
    })

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/searchBy/{userId}")
    CommentsPage getMyComments (@PathVariable String userId,
                                @Parameter(hidden = true)
                                @AuthenticationPrincipal AuthenticatedUser currentUser);

    @Operation(summary = "Update Comment by commentId", description = "Available only to authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Comment",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CommentDto.class))
                    }
            )
    })

    @PreAuthorize("isAuthenticated()")
    @PutMapping(value = "/{id}")
    ResponseEntity<CommentDto> updateComment (@PathVariable("id") String commentId,
                                              @RequestBody NewCommentDto newComment,
                                              @Parameter(hidden = true)
                                              @AuthenticationPrincipal AuthenticatedUser currentUser,
                                              String destinationId);

    @Operation(summary = "Delete Comment by commentId", description = "Available only to authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Comment",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CommentDto.class))
                    }
            )
    })

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    ResponseEntity<CommentDto> deleteComment(@PathVariable("id") String commentId);

    @Operation(summary = "Get all comments", description = "Available to everyone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of comments",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CommentDto.class))
                    }
            ),
            @ApiResponse(responseCode = "401", description = "Comments not found!!!",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            ),
            @ApiResponse(responseCode = "404", description = "This is not the web page you are looking for.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            )
    })

    @GetMapping
    CommentsPage findAll();
}
