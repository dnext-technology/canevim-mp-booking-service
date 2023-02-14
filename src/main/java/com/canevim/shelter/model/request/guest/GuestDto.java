package com.canevim.shelter.model.request.guest;


import java.util.UUID;


public record GuestDto(
        UUID id,
        String identityNumber,
        String firstName,
        String lastName

) {
}
