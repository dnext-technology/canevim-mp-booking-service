package com.canevim.shelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class CeShelterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeShelterServiceApplication.class, args);
	}

}
