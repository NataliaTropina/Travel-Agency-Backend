package com.example.travelagencybackend.validation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Validation Error")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ValidationErrorDto {

    @Schema(description = "Field, where the  error occurred", example = "email")
    private String field;

    @Schema(description = "Error message", example = "must be a well-formed email address")
    private String message;

    @Schema(description = "The value, what was received from client", example = "sidikov.marsel.com")
    private String rejectedValue;
}
