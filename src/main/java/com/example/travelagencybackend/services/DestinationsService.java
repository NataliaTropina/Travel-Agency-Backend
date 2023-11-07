package com.example.travelagencybackend.services;

import com.example.travelagencybackend.dto.DestinationDto;
import com.example.travelagencybackend.dto.DestinationsPage;
import com.example.travelagencybackend.dto.NewDestinationDto;

public interface DestinationsService {

    DestinationDto createDestination(NewDestinationDto newDestination);

    DestinationsPage findAll();

    DestinationsPage findByCity(String str);

}
