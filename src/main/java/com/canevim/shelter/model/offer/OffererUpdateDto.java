package com.canevim.shelter.model.offer;


public record OffererUpdateDto(
    String email,
    String city,
    String district,
    String town,
    String neighborhood,
    String addressDetail,
    int guestCapacity,
    String accommodationType,
    String accommodationPeriod,
    String note,
    String status){
}
