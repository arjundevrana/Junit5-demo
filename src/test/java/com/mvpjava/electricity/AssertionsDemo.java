package com.mvpjava.electricity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertionsDemo {
	CalcularotServiceImpl calcularotServiceImpl = new CalcularotServiceImpl();

	@Test
	@DisplayName("standard Assertion")
	/**
	 * This is standard
	 */
	void calculatorstandardAssertion() {

		assertEquals(4, calcularotServiceImpl.add(2, 2));
	}

	/**
	 * In a grouped assertion all assertions are executed, and any failures will be
	 * reported together.
	 */
	@Test
	@DisplayName("Grouped Assertion")
	void gourpAssertion() {
		assertAll("Calculator", () -> assertEquals(4, calcularotServiceImpl.add(2, 2)),
				() -> assertEquals(4, calcularotServiceImpl.multiply(2, 2)),
				() -> assertEquals(1, calcularotServiceImpl.divide(2, 2)));
	}

	@Test
	@DisplayName("Dependent Assertion")
	void dependentAssertions() {
		// Within a code block, if an assertion fails the
		// subsequent code in the same block will be skipped.
		assertAll("properties", () -> {

			assertEquals(4, calcularotServiceImpl.add(2, 2));

			// Executed only if the previous assertion is valid.
			assertAll("Calculator multiply and divide", () -> assertEquals(4, calcularotServiceImpl.multiply(2, 2)),
					() -> assertEquals(1, calcularotServiceImpl.divide(2, 2)));
		}, () -> {
			// Grouped assertion, so processed independently
			// of results of first name assertions.
			// calcularotServiceImpl= null;

			assertNotNull(calcularotServiceImpl);

			// Executed only if the previous assertion is valid.
			assertAll("Calculator sum and sub", () -> assertEquals(0, calcularotServiceImpl.subtract(2, 2)),
					() -> assertEquals(4, calcularotServiceImpl.add(2, 2)));
		});
	}

	@Test
	@DisplayName("Excaption Assertion")
	void exceptionTesting() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("a message");
		});
		assertEquals("a message", exception.getMessage());
	}
	
	@Test
	@DisplayName("Timeout Not Exceeded Assertion")
	    void timeoutNotExceeded() {
	        // The following assertion succeeds.
	      assertTimeout(Duration.ofMillis(100), () -> {
	            // Perform task that takes less than 2 minutes.
	    	  assertEquals("SUCCESS", calcularotServiceImpl.threadSleep());
	        });
	    }
	@Test
	@DisplayName("Timeout Exceeded With Preemptive Termination Assertion")
    void timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(10);
        });
    }
}
