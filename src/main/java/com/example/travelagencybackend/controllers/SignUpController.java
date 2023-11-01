package com.example.travelagencybackend.controllers;

import com.example.travelagencybackend.controllers.api.SignUpApi;
import com.example.travelagencybackend.dto.NewUserDto;
import com.example.travelagencybackend.dto.UserDto;
import com.example.travelagencybackend.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SignUpController implements SignUpApi {

    private final SignUpService signUpService;

    @Override
    public ResponseEntity<UserDto> signUp(NewUserDto newUser) {
        return ResponseEntity
                .status(201)
                .body(signUpService.signUp(newUser));
    }
}
