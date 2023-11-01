package com.example.travelagencybackend.services;

import com.example.travelagencybackend.dto.ProfileDto;

public interface UsersService {

    ProfileDto getProfile(String currentUserId);

}
