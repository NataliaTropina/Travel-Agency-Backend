package com.example.travelagencybackend.services;


import com.example.travelagencybackend.dto.NewUserDto;
import com.example.travelagencybackend.dto.UserDto;

public interface SignUpService {
    UserDto signUp(NewUserDto newUser);
}
