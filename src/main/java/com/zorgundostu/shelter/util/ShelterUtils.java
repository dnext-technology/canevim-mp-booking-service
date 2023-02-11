package com.zorgundostu.shelter.util;

import java.time.Instant;

public class ShelterUtils {
    private ShelterUtils(){}

    public static String generateShelterCode(String firstName, String lastName, String prefix){
        StringBuilder codeBuilder = new StringBuilder(prefix);
        codeBuilder.append(String.valueOf(firstName.charAt(0)).toUpperCase());
        codeBuilder.append(String.valueOf(lastName.charAt(0)).toUpperCase());
        codeBuilder.append(Instant.now().toEpochMilli());
        return codeBuilder.toString();
    }
}
