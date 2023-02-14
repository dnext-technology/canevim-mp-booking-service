package com.canevim.shelter.config;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.ConverterRegistry;


@Getter
@Configuration
public class ShelterConfig {
    @Bean
    @Primary
    public ConverterRegistry initConverter(ConverterRegistry registry) {
        registry.addConverterFactory(new EnumConverterFactory());
        return registry;
    }
}
