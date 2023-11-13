package com.example.travelagencybackend.controllers;

import com.example.travelagencybackend.controllers.api.DestinationsApi;
import com.example.travelagencybackend.dto.DestinationDto;
import com.example.travelagencybackend.dto.DestinationsPage;
import com.example.travelagencybackend.dto.NewDestinationDto;
import com.example.travelagencybackend.services.DestinationsService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DestinationsController implements DestinationsApi {

    private final DestinationsService destinationsService;

    @Override
    public ResponseEntity<DestinationDto> createDestination(NewDestinationDto newDestination) {
        return ResponseEntity.status(201).body(destinationsService.createDestination(newDestination));
    }

    @Override
    public DestinationsPage findAll() {
        return destinationsService.findAll();
    }

    @Override
    public DestinationsPage findByCity(@PathVariable String str) {
        return destinationsService.findByCity(str);
    }
}
