package com.mvpjava.electricity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Parameterized {

	CalcularotServiceImpl CalcularotServiceImpl = new CalcularotServiceImpl();
	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba","test" })
	void palindromes(String candidate) {
	    assertTrue(CalcularotServiceImpl.isPalimdrom(candidate));
	}
}
