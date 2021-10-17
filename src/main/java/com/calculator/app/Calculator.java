package com.calculator.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
		 parseDelimiterAndFindLineWithNumbersAndDelimiters();
         String[] inputSplittedByDelimiter = splitInputByDelimiter();
         return calculateSum(inputSplittedByDelimiter);
			}
	
	private boolean isEmptyNumber() {
		return input.length()==0;
	}
	 private void parseDelimiterAndFindLineWithNumbersAndDelimiters() {
         if (hasCustomDelimiter()) {
             parseDelimiter();
             findLineWithNumbersAndDelimiters();
         } else {
        	 numberhavingdelimiter = input;
         }
     }

     private boolean hasCustomDelimiter() {
         return input.startsWith("//");
     }


     private void findLineWithNumbersAndDelimiters() {
         int firstNewLine = input.indexOf("\n");
         numberhavingdelimiter = input.substring(firstNewLine + 1);
     }

     private void parseDelimiter() {
         delimiter = "";
         addDelimiters();
         delimiter = StringUtils.chop(delimiter);
     }

     private void addDelimiters() {
         int startIndexDelimiter = 0;
         while (true) {
             startIndexDelimiter = input.indexOf("[", startIndexDelimiter) + 1;
             if (startIndexDelimiter == 0) {
                 break;
             }
             int endIndexDelimiter = input.indexOf("]", startIndexDelimiter);
             delimiter += input.substring(startIndexDelimiter, endIndexDelimiter) + "|";
         }
     }

     private String[] splitInputByDelimiter() {
         return numberhavingdelimiter.split(delimiter);
     }

     private int calculateSum(String[] inputSplittedByDelimiter) {
         int result = 0;
         for (String token : inputSplittedByDelimiter) {
             result += addSingleToken(token);
         }
         throwExceptionIfNegativeTokensExist();
         return result;
     }

     private void throwExceptionIfNegativeTokensExist() {
         if (hasNegativeTokens()) {
             throw new IllegalArgumentException(String.format("negatives not allowed (%s)", StringUtils.join(negativenumber, ",")));
         }
     }

     private boolean hasNegativeTokens() {
         return negativenumber.size() > 0;
     }

     private int addSingleToken(String token) {
         Integer valueAsInteger = Integer.parseInt(token);
         if (isNegative(valueAsInteger)) {
        	 negativenumber.add(token);
         } else if (isInValidRange(valueAsInteger)) {
             return valueAsInteger;
         }
         return 0;
     }

     private boolean isNegative(Integer valueAsInteger) {
         return valueAsInteger < 0;
     }

     private boolean isInValidRange(Integer valueAsInteger) {
         return valueAsInteger < 1000;
     }
}
