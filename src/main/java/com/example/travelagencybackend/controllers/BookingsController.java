package com.example.travelagencybackend.controllers;

import com.example.travelagencybackend.controllers.api.BookingsApi;
import com.example.travelagencybackend.dto.BookingDto;
import com.example.travelagencybackend.dto.BookingsPage;
import com.example.travelagencybackend.dto.NewBookingDto;
import com.example.travelagencybackend.security.details.AuthenticatedUser;
import com.example.travelagencybackend.services.BookingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookingsController implements BookingsApi {

    private final BookingsService bookingsService;


    @Override
    public ResponseEntity <BookingDto> createBooking(NewBookingDto newBooking, AuthenticatedUser currentUser) {
        return ResponseEntity.status(201).body(bookingsService.createBooking(newBooking, currentUser));
    }

    @Override
    public BookingsPage getMyBookings(AuthenticatedUser currentUser) {
        return bookingsService.getMyBookings(currentUser);
    }

    @Override
    public ResponseEntity<BookingDto> updateBooking(String bookingId, NewBookingDto newBooking, AuthenticatedUser currentUser) {
        return ResponseEntity.ok(bookingsService.updateBooking(bookingId, newBooking, currentUser));
    }

    @Override
    public ResponseEntity<BookingDto> deleteBooking(String bookingId) {
        return ResponseEntity.ok(bookingsService.deleteBooking(bookingId));
    }
}
