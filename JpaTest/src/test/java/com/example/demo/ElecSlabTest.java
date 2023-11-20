package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ElecSlabTest {
	@Autowired
	private ElecSlab elecSlab; 
//	@Test
//	void billAmountFor200() {
////		ElecSlab elecSlab = new ElecSlab();
//		assertEquals(1000.0, elecSlab.billAmount(200));
//	}
//	
//	@Test
//	void billAmountForZero() {
//		assertEquals(65.0, elecSlab.billAmount(0));
//	}
//	@Test
//	void billAmount() {
//		assertEquals(350.0, elecSlab.billAmount(70));
//	}
	
	@ParameterizedTest
	@ValueSource(ints = {200})
	void billAmountParameter(int i) {
		assertTrue(elecSlab.billAmountCheck(i));
	}

}
