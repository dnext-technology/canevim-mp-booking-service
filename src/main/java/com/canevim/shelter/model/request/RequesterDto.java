package com.canevim.shelter.model.request;


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
        String createdDate
) {
}
