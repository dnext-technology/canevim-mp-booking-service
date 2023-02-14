package com.canevim.shelter.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;


public class ShelterHttpUtils {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static String generateCorrelationId(String correlationIdPrefix) {
        String prefix = ObjectUtils.isEmpty(correlationIdPrefix) ? ShelterHttpClientConstants.CORRELATION_ID_PREFIX: correlationIdPrefix;
        var formatter = DateTimeFormatter.ofPattern(ShelterHttpClientConstants.CORRELATION_ID_PREFIX);
        var time = LocalDateTime.now();
        return prefix + time.format(formatter);
    }


    private static String[] generateHttpDefaultStringHeader() {
        return new String[]{
                ShelterHttpClientConstants.CONTENT_TYPE_KEY,
                ShelterHttpClientConstants.CONTENT_TYPE_VALUE,
                ShelterHttpClientConstants.CORRELATION_ID,
                generateCorrelationId(ShelterHttpClientConstants.CORRELATION_ID_PREFIX)

        };

    }

    public static Map<String, String> generateHttpDefaultHeader() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put(ShelterHttpClientConstants.CONTENT_TYPE_KEY, ShelterHttpClientConstants.CONTENT_TYPE_VALUE);
        return headerMap;
    }

    public static Map<String, String> generateHttpDefaultHeaderWithToken(String token) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put(ShelterHttpClientConstants.CONTENT_TYPE_KEY, ShelterHttpClientConstants.CONTENT_TYPE_VALUE);
        headerMap.put(ShelterHttpClientConstants.AUTHORIZATION_KEY, ShelterHttpClientConstants.BEARER_KEY + token);
        return headerMap;
    }

    public static Map<String, String> generateHttpDefaultHeaderWithContentType(String contentType) {
        if (ObjectUtils.isEmpty(contentType)) {
            return generateHttpDefaultHeader();
        } else {
            Map<String, String> headerMap = new HashMap<>();
            headerMap.put(ShelterHttpClientConstants.CONTENT_TYPE_KEY, contentType);
            return headerMap;
        }
    }




    private ShelterHttpUtils() {
    }
}
