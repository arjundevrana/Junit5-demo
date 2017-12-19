package com.mvpjava.electricity;

public class Calculator {
	CalculatorService calculatorService;

	public Calculator(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	public int addValue(int x, int y) {
		return calculatorService.add(x, y);

	}
	public int subValue(int x, int y) {
		return calculatorService.subtract(x, y);

	}
	public int multiValue(int x, int y) {
		return calculatorService.multiply(x, y);

	}
	public int divisionValue(int x, int y) {
		return calculatorService.divide(x, y);

	}
	public int fibonic(int x) {
		return calculatorService.fibonacci(x);

	}
}
