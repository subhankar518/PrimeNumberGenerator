package com.example.PrimeNumberGenerator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimeNumberGeneratorApplicationTests {

	TestingMethods testingMethods=new TestingMethods();
	
	@Test
	void testSize()
	{
		int expectedSize=4;
		int actualSize=testingMethods.primeGenerate(10, 20);
		
		assertThat(actualSize).isEqualTo(expectedSize);
	}

}
