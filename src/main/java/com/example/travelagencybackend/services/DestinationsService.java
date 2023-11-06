package com.example.travelagencybackend.services;

import com.example.travelagencybackend.dto.DestinationDto;
import com.example.travelagencybackend.dto.DestinationsPage;
import com.example.travelagencybackend.dto.NewDestinationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinationsService {

    DestinationDto createDestination(NewDestinationDto newDestination);

    DestinationsPage findAll();

    DestinationsPage findByCityOrDescription(String str);

}
