package com.zorgundostu.shelter.config;

import java.util.UUID;

import com.zorgundostu.shelter.model.request.Requester;
import lombok.Getter;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;


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
