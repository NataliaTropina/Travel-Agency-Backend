package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.NewUserDto;
import com.example.travelagencybackend.dto.UserDto;
import com.example.travelagencybackend.models.User;
import com.example.travelagencybackend.repositories.UsersRepository;
import com.example.travelagencybackend.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.travelagencybackend.dto.UserDto.from;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto signUp(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .hashPassword(passwordEncoder.encode(newUser.getPassword()))
                .role(User.Role.USER)
                .build();

        usersRepository.save(user);

        return from(user);
    }
}
