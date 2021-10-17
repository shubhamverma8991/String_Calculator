package com.calculator.app;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	
	private final String input;
	private String delimiter="[,\n]";
	private String numberhavingdelimiter;
	private List<String> negativenumber=new ArrayList<String>();
	
	public Calculator(String input) {
		super();
		this.input=input;
	}
	
	public int add() {
		if(isEmptyNumber()) {
			return 0;
		}
		return 1;
	}
	
	private boolean isEmptyNumber() {
		return input.length()==0;
	}
}
