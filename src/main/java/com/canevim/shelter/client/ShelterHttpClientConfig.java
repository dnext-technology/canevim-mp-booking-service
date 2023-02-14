package com.canevim.shelter.client;

import java.net.http.HttpClient;
import java.time.Duration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Getter
@Configuration
public class ShelterHttpClientConfig {
    @Value("${shelter.http.client.timeout:30}")
    private long connectionTimeout;

    @Bean(name = ShelterHttpClientConstants.SHELTER_HTTP_CLIENT)
    @Primary
    public HttpClient shelterHttpClient() {
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(connectionTimeout))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .priority(1)
                .version(HttpClient.Version.HTTP_2)
                .build();
    }
}
