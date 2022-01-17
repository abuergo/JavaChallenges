package com.coderhouse.applyingSpringBoot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplyingSpringBootApplication {
	private static final Logger LOGGER = LogManager.getLogger(ApplyingSpringBootApplication.class);


	public static void main(String[] args) {



		SpringApplication.run(ApplyingSpringBootApplication.class, args);
	}



}
