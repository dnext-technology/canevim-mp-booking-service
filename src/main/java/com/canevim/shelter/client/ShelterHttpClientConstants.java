package com.canevim.shelter.client;

public final class ShelterHttpClientConstants {
    private ShelterHttpClientConstants(){}

    /*Headers & Keys */
    public static final String X_FORWARDED_FOR_HEADER = "x-forwarded-for";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
    public static final String CORRELATION_ID = "correlationId";
    public static final String CORRELATION_ID_PREFIX = "shelter-";

    public static final String AUTHORIZATION_KEY = "Authorization";
    public static final String TOKEN_KEY = "token";
    public static final String BEARER_KEY = "Bearer ";

    /* Utils */
    public static final String SHELTER_HTTP_CLIENT = "shelterHttpRestClient";
    public static final String CORRELATION_ID_DATE_FORMAT = "yyyyMMddHHmmssS";



}
