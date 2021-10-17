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
	
	@Test
	void test_singleNumber_2() {
		assertEquals(2,cal.add("2"));
	}
	
	@Test
	void test_twonumber() {
		assertEquals(5,cal.add("2,3"));
	}
	
	@Test
	void test_3_number() {
		assertEquals(12,cal.add("2,4,6"));
	}
	
	@Test
	void test_3_number_withnewline() {
		assertEquals(12,cal.add("2\n4,6"));
	}
	
	

}
