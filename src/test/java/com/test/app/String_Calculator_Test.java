package com.test.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculator.app.StringCalculator;

class String_Calculator_Test {

	StringCalculator cal=new StringCalculator();
	
	@Test
	void test_null_number() {
		assertEquals(0,cal.add(""));
	}
	
	@Test
	void test_singleNumber() {
		assertEquals(1,cal.add("1"));
	}
	
	

}
