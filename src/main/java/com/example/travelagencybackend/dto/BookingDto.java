package com.example.travelagencybackend.dto;

import com.example.travelagencybackend.models.Booking;
import com.example.travelagencybackend.models.Destination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {

    private String id;
    private LocalDate createdDate;
    private String userId;
    private List<String> destinationIds;
    private double totalPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public static BookingDto from(Booking booking) {
        return BookingDto.builder()
                .id(booking.getId())
                .createdDate(booking.getCreatedDate())
                .userId(booking.getUser().getId())
                .destinationIds(booking.getDestinations().stream().map(Destination::getId).collect(Collectors.toList()))
                .totalPrice(booking.getTotalPrice())
                .startDate(booking.getStartDate())
                .endDate(booking.getEndDate())
                .build();
    }

    public static List<BookingDto> from(List<Booking> bookings) {

        return bookings.stream().map(BookingDto::from).collect(Collectors.toList());
    }
}
