package com.example.travelagencybackend.services.impl;

import com.example.travelagencybackend.dto.BookingDto;
import com.example.travelagencybackend.dto.BookingsPage;
import com.example.travelagencybackend.dto.NewBookingDto;
import com.example.travelagencybackend.exceptions.NotFoundException;
import com.example.travelagencybackend.models.Booking;
import com.example.travelagencybackend.models.Destination;
import com.example.travelagencybackend.models.User;
import com.example.travelagencybackend.repositories.BookingsRepository;
import com.example.travelagencybackend.repositories.UsersRepository;
import com.example.travelagencybackend.repositories.DestinationsRepository;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.services.BookingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.example.travelagencybackend.dto.BookingDto.from;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository bookingsRepository;

    private final UsersRepository usersRepository;

    private final DestinationsRepository destinationsRepository;



    @Override
    public BookingDto createBooking(NewBookingDto newBooking, AuthenticatedUser currentUser) {

        User user = usersRepository.findById(currentUser.getUser().getId())
                .orElseThrow(()->
                        new NotFoundException("User with id <" + currentUser.getUser().getId() + "> not found"));

        List<Destination> destinationList = (List<Destination>) destinationsRepository.findAllById(newBooking.getDestinationIds());

        Booking booking = null;
        double totalBookingPrice = 0.0;
        if(!destinationList.isEmpty()) {

            for (Destination destination : destinationList){
                totalBookingPrice += destination.getPrice();
            }

            booking = Booking.builder()
                    .createdDate(LocalDate.now())
                    .user(user)
                    .destinations(destinationList)
                    .totalPrice(totalBookingPrice)
                    .startDate(newBooking.getStartDate())
                    .endDate(newBooking.getEndDate())
                    .build();

            bookingsRepository.save(booking);
        } else {
            throw new IllegalArgumentException("There is no destination");
        }
        return from(booking);
    }

    @Override
    public BookingsPage getMyBookings(AuthenticatedUser currentUser) {

        User user = usersRepository.findById(currentUser.getUser().getId())
                .orElseThrow(()->
                        new NotFoundException("User with id <" + currentUser.getUser().getId() + "> not found"));

    List<Booking> bookingsByUser = bookingsRepository.findAllByUser(user);

        return BookingsPage.builder()
                .data(from(bookingsByUser))
                .build();
    }

    @Override
    public BookingDto updateBooking(String bookingId, NewBookingDto newBooking, AuthenticatedUser currentUser) {

        User user = usersRepository.findById(currentUser.getUser().getId())
                .orElseThrow(() ->
                        new NotFoundException("User with id <" + currentUser.getUser().getId() + "> not found"));

        List<Booking> bookingsByUser = bookingsRepository.findAllByUser(user);

        Booking bookingToUpdate = null;

        for (Booking booking : bookingsByUser) {
            if (booking.getId().equals(bookingId)) {

                booking.setCreatedDate(newBooking.getCreatedDate());
                booking.setEndDate(newBooking.getEndDate());

                List<Destination> destinationList = (List<Destination>) destinationsRepository.findAllById(newBooking.getDestinationIds());

                booking.setDestinations(destinationList);

                bookingsRepository.save(booking);

                bookingToUpdate = booking;
            }
        }
        if (bookingToUpdate != null) {
            return from(bookingToUpdate);

        }else {
            throw new NotFoundException("Booking is not available");
        }
    }

    @Override
    public BookingDto deleteBooking(String bookingId) {

        Booking booking = bookingsRepository.findById(bookingId)
                .orElseThrow(()->
                        new NotFoundException("Booking with id <" + bookingId + "> not found")
                );

        bookingsRepository.deleteById(bookingId);

        return from(booking);
    }

}
