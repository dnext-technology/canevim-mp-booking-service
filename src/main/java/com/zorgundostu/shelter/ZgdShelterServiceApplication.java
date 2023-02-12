package com.zorgundostu.shelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class ZgdShelterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZgdShelterServiceApplication.class, args);
	}

}
