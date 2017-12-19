package com.mvpjava.electricity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class CalculatorTest {
	Calculator calculator=null;
	CalculatorService calculatorService = mock(CalculatorService.class);
	@BeforeEach
	public void init() {
		calculator = new Calculator(calculatorService);
		System.out.println("Hi............");
	}

	@Test
	void additionTest() {
		when(calculatorService.add(3, 4)).thenReturn(7);
		assertEquals(7, calculator.addValue(3, 4));
	}
}
