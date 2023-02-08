package com.zorgundostu.booking.util;

import java.time.Instant;

public class BookingUtils {
    private BookingUtils(){}

    public static String generateBookingCode(String firstName, String lastName, String prefix){
        StringBuilder codeBuilder = new StringBuilder(prefix);
        codeBuilder.append(String.valueOf(firstName.charAt(0)).toUpperCase());
        codeBuilder.append(String.valueOf(lastName.charAt(0)).toUpperCase());
        codeBuilder.append(Instant.now().toEpochMilli());
        return codeBuilder.toString();
    }
}
