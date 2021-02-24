package com.my.travelmap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.travelmap.mapper.UserMapper;

@SpringBootTest
public class TravelmapApplicationTests {
	
	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
	}

}
