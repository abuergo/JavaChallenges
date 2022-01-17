package com.example.applyinglogs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplyinglogsApplication {
	private static final Logger LOGGER = LogManager.getLogger(ApplyinglogsApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Information log");
		LOGGER.error("Error log");
		LOGGER.warn("Warn log");

		SpringApplication.run(ApplyinglogsApplication.class, args);

	}

}
