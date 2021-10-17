package com.test.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculator.app.StringCalculator;

class String_Calculator_Test {

	StringCalculator cal=new StringCalculator();
	
	@Test
	void test_Null_Number() {
		assertEquals(0,cal.add(""));
	}
	
	@Test
	void test_SingleNumber() {
		assertEquals(1,cal.add("1"));
	}
	
	@Test
	void test_SingleNumber_2() {
		assertEquals(2,cal.add("2"));
	}
	
	@Test
	void test_TwoNumber() {
		assertEquals(5,cal.add("2,3"));
	}
	
	@Test
	void test_3_Number() {
		assertEquals(12,cal.add("2,4,6"));
	}
	
	@Test
	void test_3_Number_WithNewLine_andcomma() {
		assertEquals(12,cal.add("2\n4,6"));
	}
	
	@Test
	void test_3_Number_WithNewLine() {
		assertEquals(12,cal.add("2\n4\n6"));
	}
	
	
	@Test
	void negativeNumber_test1() {
		cal.add("-2,1");
	}
	
	@Test
	void negativeNumber_test2() {
		cal.add("-2,-1");
	}
	
	@Test
	void negativeNumber_test3() {
		cal.add("-2,-1,-11");
	}
	
	@Test
	void numberGreaterThan1k_Test1() {
		assertEquals(2,cal.add("2,1002"));
	}
	
	@Test
	void numberGreaterThan1k_Test2() {
		assertEquals(0,cal.add("1004,1002"));
	}
	
	@Test
	void numberGreaterThan1k_Test3() {
		assertEquals(2,cal.add("1004,1002,2"));
	}
	
	
	
	
	

}
