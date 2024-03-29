package com.canevim.shelter.service.util;

import java.time.Instant;

import com.canevim.shelter.model.ministry.ShelterDto;
import com.canevim.shelter.model.offer.Offerer;


public class ShelterUtils {
    private ShelterUtils(){}

    public static String generateShelterCode(String firstName, String lastName, String prefix){
        StringBuilder codeBuilder = new StringBuilder(prefix);
        codeBuilder.append(String.valueOf(firstName.charAt(0)).toUpperCase());
        codeBuilder.append(String.valueOf(lastName.charAt(0)).toUpperCase());
        codeBuilder.append(Instant.now().toEpochMilli());
        return codeBuilder.toString();
    }

    public static ShelterDto generateShelterObjectToSendMinistry(Offerer offerer){
        StringBuilder addressBuilder = new StringBuilder(offerer.getNeighborhood());
        addressBuilder.append(" / ");
        addressBuilder.append(offerer.getDistrict());
        addressBuilder.append(" ");
        addressBuilder.append(offerer.getAddressDetail());

        return new ShelterDto(
          offerer.getId().toString(),
          offerer.getIdentityNumber(),
          offerer.getFirstName(),
          offerer.getLastName(),
          offerer.getPhone(),
          offerer.getEmail(),
          offerer.getCity(),
          offerer.getDistrict(),
          offerer.getAddressDetail(),
          offerer.getRoomType(),
          offerer.getGuestCapacity(),
          offerer.isFurnished(),
          offerer.getAccommodationAvailabilityStartDate().toString(),
          offerer.getAccommodationAvailabilityDay(),
          offerer.getNote(),
          "CANEVIM"
        );
    }
}
