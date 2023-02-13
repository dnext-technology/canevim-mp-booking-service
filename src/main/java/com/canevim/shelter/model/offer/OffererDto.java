package com.canevim.shelter.model.offer;


import java.time.LocalDate;
import java.util.UUID;


public record OffererDto(
        UUID id,
        String firstName,
        String lastName,
        String city,
        String district,
        String town,
        String neighborhood,
        String addressDetail,
        int guestCapacity,
        String accommodationType,
        String accommodationPeriod,
        String note,
        String status,
        LocalDate accommodationAvailabilityDate,
        int accommodationAvailabilityDay,
        String roomType,
        boolean furnished,
        String createdDate
) {
}
