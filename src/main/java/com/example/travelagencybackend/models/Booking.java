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

    private LocalDate createdDate;

    private User user;

    private List<Destination> destinations;

    private double totalPrice;

    private LocalDate startDate;

    private LocalDate endDate;

}
