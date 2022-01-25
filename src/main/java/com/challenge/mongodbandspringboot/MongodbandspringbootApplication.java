package com.challenge.mongodbandspringboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbandspringbootApplication {

	static Logger LOGGER = LogManager.getLogger(MongodbandspringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MongodbandspringbootApplication.class, args);
	}

}
