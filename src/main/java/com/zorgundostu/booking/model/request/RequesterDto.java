package com.zorgundostu.booking.model.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;


public record RequesterDto(

        Long id,
        String code,
        String firstName,

        String lastName,

        String city,

        String district,
        int adultNumber,
        int childNumber,
        String accommodationPeriod,
        String note,
        String status,
        String createdDate
) {
}
