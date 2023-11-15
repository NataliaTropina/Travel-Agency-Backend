package com.example.travelagencybackend.services;

import com.example.travelagencybackend.dto.BookingDto;
import com.example.travelagencybackend.dto.BookingsPage;
import com.example.travelagencybackend.dto.NewBookingDto;
import com.example.travelagencybackend.security.details.AuthenticatedUser;

public interface BookingsService {

    BookingDto createBooking(NewBookingDto newBooking, AuthenticatedUser currentUser);

    BookingsPage getMyBookings(AuthenticatedUser currentUser);

    BookingDto updateBooking(String bookingId, NewBookingDto newBooking, AuthenticatedUser currentUser);

    BookingDto deleteBooking(AuthenticatedUser currentUser, String bookingId);
}
