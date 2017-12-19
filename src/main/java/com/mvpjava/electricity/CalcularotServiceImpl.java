package com.mvpjava.electricity;

public class CalcularotServiceImpl implements CalculatorService {

	@Override
	public int add(int a, int b) {
		return a + b;

	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}

	@Override
	public int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);

	}

	public String threadSleep() throws InterruptedException {
		Thread.sleep(200);
		return "SUCCESS";
	}
}
