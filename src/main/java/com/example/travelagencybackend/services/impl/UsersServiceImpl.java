package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.ProfileDto;
import com.example.travelagencybackend.models.User;
import com.example.travelagencybackend.repositories.UsersRepository;
import com.example.travelagencybackend.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public ProfileDto getProfile(String currentUserId) {
        User user = usersRepository.findById(currentUserId)
                .orElseThrow(IllegalArgumentException::new);

        return ProfileDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
