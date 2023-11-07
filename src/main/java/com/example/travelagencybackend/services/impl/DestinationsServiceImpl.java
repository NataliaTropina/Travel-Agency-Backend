package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.DestinationDto;
import com.example.travelagencybackend.dto.DestinationsPage;
import com.example.travelagencybackend.dto.NewDestinationDto;
import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.repositories.DestinationsRepository;
import com.example.travelagencybackend.services.DestinationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DestinationsServiceImpl implements DestinationsService {

    private final DestinationsRepository destinationsRepository;

    @Override
    public DestinationDto createDestination(NewDestinationDto newDestination) {
        Destination destination = Destination.builder()
                .city(newDestination.getCity())
                .description(newDestination.getDescription())
                .imageUrl(newDestination.getImageUrl())
                .price(newDestination.getPrice())
                .build();
        destinationsRepository.save(destination);
        return DestinationDto.from(destination);
    }


    @Override
    public DestinationsPage findAll() {
        List<Destination> destinations = destinationsRepository.findAll();
      return DestinationsPage
              .builder()
              .data(DestinationDto.from(destinations))
              .build();
    }

    @Override
    public DestinationsPage findByCity(String str) {

        List<Destination> destinations = destinationsRepository.findByCity(str);
        return DestinationsPage
                .builder()
                .data(DestinationDto.from(destinations))
                .build();
    }
}
