package com.canevim.shelter.model.request.guest;

import jakarta.validation.constraints.NotNull;

public record GuestCreateDto(
        @NotNull
        String identityNumber,
        @NotNull
        String firstName,
        @NotNull
        String lastName
) {
}
