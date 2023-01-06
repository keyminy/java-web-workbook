package org.zerock.springex.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class SampleTests {

	@Autowired
	private SampleService sampleService;
	
	@Test
	public void testService1() {
		log.info(sampleService);
		Assertions.assertNotNull(sampleService);
	}
}
