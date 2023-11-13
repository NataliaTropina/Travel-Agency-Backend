package com.example.travelagencybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewBookingDto {

    private LocalDate createdDate;
    private List<String> destinationIds;
    private LocalDate startDate;
    private LocalDate endDate;
}
