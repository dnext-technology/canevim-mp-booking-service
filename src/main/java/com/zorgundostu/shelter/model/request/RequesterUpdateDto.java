package com.zorgundostu.shelter.model.request;


public record RequesterUpdateDto(
        String firstName,
        String lastName,
        String city,
        String district,
        int adultNumber,
        int childNumber,
        String accommodationPeriod,
        String note,
        String status
) {
}
