package com.example.travelagencybackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;
    @EqualsAndHashCode.Exclude
    private LocalDate createdDate;
    @EqualsAndHashCode.Exclude
    private User user;
    @EqualsAndHashCode.Exclude
    private List<Destination> destinations;
    @EqualsAndHashCode.Exclude
    private double totalPrice;
    @EqualsAndHashCode.Exclude
    private LocalDate startDate;
    @EqualsAndHashCode.Exclude
    private LocalDate endDate;

}
