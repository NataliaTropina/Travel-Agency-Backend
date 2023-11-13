package com.example.travelagencybackend.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Validation Error")
public class ValidationErrorsDto {

    @Schema(description = "List of errors")
    private List<ValidationErrorDto> errors;
}
