package com.example.travelagencybackend.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {

    @Schema(description = "users Email", example = "simple@mail.com")
    @Email
    @NotNull
    @NotBlank
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate createdDate;

    @Schema(description = "users password", example = "qwerty007")
    @NotBlank
    @Size(min = 7, max = 1000)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Weak password")
    private String password;
}