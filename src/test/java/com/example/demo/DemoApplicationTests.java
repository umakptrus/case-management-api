package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.mapper.DisputeMapper;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DemoApplicationTests {

	@InjectMocks
	private DemoApplication demoApplication;

	@MockBean
	private DisputeMapper disputeMapper; // Mock the DisputeMapper bean

	@Test
	void contextLoads() {
		// Verify that the application context loads and the main application bean is
		// not null
		assertNotNull(demoApplication, "DemoApplication bean should not be null");
	}
}