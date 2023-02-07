package com.zorgundostu.booking.model.request;

import jakarta.validation.constraints.NotNull;


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
