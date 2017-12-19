package com.mvpjava.electricity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DisabledTestsDemo {

	CalcularotServiceImpl calcularotServiceImpl = new CalcularotServiceImpl();

	@Test
	void sumTest() {
		assertEquals(4, calcularotServiceImpl.add(3, 1));
	}

	@Disabled
	@Test
	void SubTest() {
		assertEquals(2, calcularotServiceImpl.subtract(3, 1));
	}

}
