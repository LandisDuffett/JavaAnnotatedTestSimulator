package TestDemo;

import TestDemo.Sample;

public class SampleTest {
	@MyAnnotation
	public static void testAdditionPositive() {
		Sample calc = new Sample();
		
		// actual output
		int actualOutput = calc.addition(4, 3);
		// expected output
		int expectedOutput = 7;
		// check if expected output is equal to actual output
		System.out.println(actualOutput == expectedOutput);
	
	}
	
	@MyAnnotation
	public static void testAdditionNegative() {
		Sample calc = new Sample();
		int actualOutput = calc.addition(-8, -2);
		int expectedOutput = -10;
		System.out.println(actualOutput == expectedOutput);

	}
}
