package com.canevim.shelter.client;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;


@Component
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            Enumeration<String> headerNames = httpRequest.getHeaderNames();
            if (headerNames != null) {
                String token = httpRequest.getHeader(ShelterHttpClientConstants.AUTHORIZATION_KEY);
                MDC.put(ShelterHttpClientConstants.TOKEN_KEY, ShelterHttpClientConstants.BEARER_KEY + token);
            }
            MDC.put(ShelterHttpClientConstants.CORRELATION_ID, generateCorrelationId());
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(ShelterHttpClientConstants.TOKEN_KEY);
            MDC.remove(ShelterHttpClientConstants.CORRELATION_ID);
        }
    }

    private static String generateCorrelationId() {
        var formatter = DateTimeFormatter.ofPattern(ShelterHttpClientConstants.CORRELATION_ID_DATE_FORMAT);
        var time = LocalDateTime.now();
        return ShelterHttpClientConstants.CORRELATION_ID_PREFIX + time.format(formatter);
    }
}
