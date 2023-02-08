package com.zorgundostu.booking.model.offer;


public record OffererDto(
        Long id,
        String code,
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
        String createdDate
) {
}
