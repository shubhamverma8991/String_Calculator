package com.calculator.app;

public class StringCalculator {

	public int add(String input)
	{
		Calculator cal =new Calculator(input);
		return cal.add();
	}
}
