package edu.grinnell.csc207.nguyenti.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEvaluate() throws Exception {
		assertEquals("basic expression", 0, Calculator.evaluate("1 + 1").compareTo(new Fraction(2)));
		assertEquals("storage", 0, Calculator.evaluate("r0 = 1 + 1").compareTo(Calculator.r[0]));
		assertEquals("fractions", 0, Calculator.evaluate("1/2").compareTo(new Fraction(1, 2)));
		assertEquals("multiply", 0, Calculator.evaluate("1 * 2").compareTo(new Fraction(2)));
		assertEquals("divide", 0, Calculator.evaluate("1 / 2").compareTo(new Fraction(1, 2)));
		assertEquals("subtract", 0, Calculator.evaluate("1 - 1/2").compareTo(new Fraction(1, 2)));
		assertEquals("add", 0, Calculator.evaluate("1 + 2").compareTo(new Fraction(3)));
		assertEquals("multiple storage", 0, Calculator.evaluate("r0 = r1 = 1 + 1").compareTo(Calculator.r[0]));
	}

}
