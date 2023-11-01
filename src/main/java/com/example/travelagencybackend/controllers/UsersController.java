package com.example.travelagencybackend.controllers;

import com.example.travelagencybackend.controllers.api.UsersApi;
import com.example.travelagencybackend.dto.ProfileDto;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController implements UsersApi {

    private final UsersService usersService;

    @PreAuthorize("isAuthenticated()")
    @Override
    public ResponseEntity<ProfileDto> getProfile(AuthenticatedUser currentUser) {
        String currentUserId = currentUser.getUser().getId();
        ProfileDto profile = usersService.getProfile(currentUserId);

        return ResponseEntity.ok(profile);
    }


}