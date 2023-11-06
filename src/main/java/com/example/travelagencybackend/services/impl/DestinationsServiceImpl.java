package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.DestinationDto;
import com.example.travelagencybackend.dto.DestinationsPage;
import com.example.travelagencybackend.dto.NewDestinationDto;
import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.repositories.DestinationRepository;
import com.example.travelagencybackend.services.DestinationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DestinationsServiceImpl implements DestinationsService {

    private final DestinationRepository destinationRepository;

    @Override
    public DestinationDto createDestination(NewDestinationDto newDestination) {
        Destination destination = Destination.builder()
                .city(newDestination.getCity())
                .description(newDestination.getDescription())
                .imageUrl(newDestination.getImageUrl())
                .price(newDestination.getPrice())
                .build();
        destinationRepository.save(destination);
        return DestinationDto.from(destination);
    }


    @Override
    public DestinationsPage findAll() {
        List<Destination> destinations = destinationRepository.findAll();
      return DestinationsPage
              .builder()
              .data(DestinationDto.from(destinations))
              .build();
    }

    @Override
    public DestinationsPage findByCityOrDescription(String str) {
        String findStr = '%' + str.toLowerCase() + '%';
        List<Destination> destinations = destinationRepository.findByCityOrDescription(findStr);
        return DestinationsPage
                .builder()
                .data(DestinationDto.from(destinations))
                .build();
    }
}
