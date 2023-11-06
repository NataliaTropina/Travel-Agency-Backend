package com.example.travelagencybackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "StandardResponseDto", description = "request details")
public class StandardResponseDto {
    @Schema(description = "Message text")
    private String message;
}
