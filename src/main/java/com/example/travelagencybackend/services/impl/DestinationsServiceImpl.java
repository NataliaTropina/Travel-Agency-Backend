package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.DestinationDto;
import com.example.travelagencybackend.dto.DestinationsPage;
import com.example.travelagencybackend.dto.NewDestinationDto;
import com.example.travelagencybackend.models.Comment;
import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.models.Rating;
import com.example.travelagencybackend.repositories.CommentsRepository;
import com.example.travelagencybackend.repositories.DestinationsRepository;
import com.example.travelagencybackend.repositories.RatingsRepository;
import com.example.travelagencybackend.services.DestinationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DestinationsServiceImpl implements DestinationsService {

    private final DestinationsRepository destinationsRepository;

    private final RatingsRepository ratingsRepository;

    private final CommentsRepository commentsRepository;

    @Override
    public DestinationDto createDestination(NewDestinationDto newDestination) {

        Rating rating = new Rating();
        ratingsRepository.save(rating);

        Comment comment = new Comment();
        commentsRepository.save(comment);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);


        Destination destination = Destination.builder()
                .city(newDestination.getCity())
                .description(newDestination.getDescription())
                .imageUrl(newDestination.getImageUrl())
                .price(newDestination.getPrice())
                .comments(comments)
                .rating(rating)
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
