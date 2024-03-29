package com.canevim.shelter.model.request;

import java.time.LocalDate;
import java.util.List;

import com.canevim.shelter.model.request.guest.GuestCreateDto;
import jakarta.validation.constraints.NotNull;


public record RequesterCreateDto(
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
        String neighborhood,
        String addressDetail,
        @NotNull
        int adultNumber,
        int childNumber,
        String accommodationPeriod,
        boolean transportationRequired,
        String note,
        String status,
        List<GuestCreateDto> guestList

) {
}
