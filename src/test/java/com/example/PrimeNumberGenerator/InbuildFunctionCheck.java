package com.example.PrimeNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.PrimeNumberGenerator.repository.UserRepositoryInterf;

@SpringBootTest
public class InbuildFunctionCheck {
	
	@Autowired
	UserRepositoryInterf userRepositoryInterf;
	
	@Test
	void existByIdCheck()  // its a testing of inbuild func
	{
		Boolean result=userRepositoryInterf.existsById(1);
		assertThat(result).isTrue();	
	}

}
