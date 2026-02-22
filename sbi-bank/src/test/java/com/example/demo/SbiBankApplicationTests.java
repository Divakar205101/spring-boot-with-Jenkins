package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbiBankApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SbiBankApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Spring Boot test context loaded successfully");
	}

}
