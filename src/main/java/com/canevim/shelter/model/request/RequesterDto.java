package com.canevim.shelter.model.request;


import com.canevim.shelter.model.request.guest.GuestDto;

import java.util.List;
import java.util.UUID;


public record RequesterDto(
        UUID id,
        String code,
        String firstName,
        String lastName,
        String city,
        String district,
        int adultNumber,
        int childNumber,
        String accommodationPeriod,
        boolean transportationRequired,
        String note,
        String status,
        String createdDate,
        List<GuestDto> guestList

) {
}
