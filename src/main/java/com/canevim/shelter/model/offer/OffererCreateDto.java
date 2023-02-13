package com.canevim.shelter.model.offer;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OffererCreateDto(
        @NotNull
        String identityNumber,
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        LocalDate birthDate,
        String email,
        @NotNull
        String phone,
        @NotNull
        String city,
        @NotNull
        String district,
        String town,
        @NotNull
        String neighborhood,
        String addressDetail,
        int guestCapacity,
        @NotNull
        String accommodationType,
        String accommodationPeriod,
        LocalDate accommodationAvailabilityStartDate,
        LocalDate accommodationAvailabilityEndDate,
        int accommodationAvailabilityDay,
        String roomType,
        boolean furnished,
        String note
) {
}
