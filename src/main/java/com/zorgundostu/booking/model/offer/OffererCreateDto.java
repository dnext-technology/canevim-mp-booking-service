package com.zorgundostu.booking.model.offer;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;


public record OffererCreateDto(
        @NotNull
        String identityNumber,
        @NotNull
        String firstName,
        @NotNull
        String lastName,
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
        @NotNull
        String accommodationPeriod,
        String note
) {
}
