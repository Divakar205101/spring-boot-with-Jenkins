package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SbiBankApplication {
	
	private static final Logger logger =
            LoggerFactory.getLogger(SbiBankApplication.class);
	

	public static void main(String[] args) {
		logger.info("Starting SBI Bank Application...");
		SpringApplication.run(SbiBankApplication.class, args);
	}
	
	@PostConstruct
    public void name() {
        logger.info("SbiBankApplication initialized successfully");
    }

}
