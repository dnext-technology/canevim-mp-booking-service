package com.zorgundostu.booking.model.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;


public record RequesterCreateDto(
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
        String neighborhood,
        String addressDetail,
        @NotNull
        int adultNumber,
        int childNumber,
        String accommodationPeriod,
        String note,
        String status
) {
}
