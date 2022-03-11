package com.sdk;

import com.sdk.service.HomeService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HomeServiceTests {

	@Autowired
	private HomeService homeService;

	@Test
	void contextLoads() {
		assertThat(homeService.health()).isNotNull();
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
