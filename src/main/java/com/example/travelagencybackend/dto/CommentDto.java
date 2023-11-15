package com.example.travelagencybackend.dto;

import com.example.travelagencybackend.models.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Existing comment")
public class CommentDto {

    private String id;
    private LocalDate createdDate;
    private String description;
    private String userId;
    private String destinationId;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .createdDate(comment.getCreatedDate())
                .description(comment.getDescription())
                .userId(comment.getUser().getId())
                .destinationId(comment.getDestination().getId())
                .build();
    }

    public static List<CommentDto> from(List<Comment> comments) {
        return comments.stream()
                .map(CommentDto::from)
                .collect(Collectors.toList());
    }
}
