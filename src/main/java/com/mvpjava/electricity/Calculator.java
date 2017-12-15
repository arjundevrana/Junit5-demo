package com.mvpjava.electricity;

public class Calculator {
	CalculatorService calculatorService;

	public Calculator(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	public int addValue(int x, int y) {
		return calculatorService.add(x, y)*x;

	}

}
