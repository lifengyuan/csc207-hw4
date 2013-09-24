package edu.grinnell.csc207.nguyenti.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testEvaluate() throws Exception {
	assertEquals("basic expression", 0, Calculator.evaluate("1 + 1")
		.compareTo(new Fraction(2)));
	assertEquals("single value", 0,
		Calculator.evaluate("42").compareTo(new Fraction(42)));
	assertEquals("storage", 0,
		Calculator.evaluate("r0 = 1 + 1").compareTo(Calculator.r[0]));
	assertEquals("single storage", 0,
		Calculator.evaluate("r0").compareTo(new Fraction(2)));
	assertEquals("fractions", 0,
		Calculator.evaluate("1/2").compareTo(new Fraction(1, 2)));
	assertEquals("multiply", 0,
		Calculator.evaluate("1 * 2").compareTo(new Fraction(2)));
	assertEquals("divide", 0,
		Calculator.evaluate("1 / 2").compareTo(new Fraction(1, 2)));
	assertEquals("subtract", 0,
		Calculator.evaluate("1 - 1/2").compareTo(new Fraction(1, 2)));
	assertEquals("add", 0,
		Calculator.evaluate("1 + 2").compareTo(new Fraction(3)));
	assertEquals(
		"multiple storage r0",
		0,
		Calculator.evaluate("r0 = r1 = 1 + 1").compareTo(
			Calculator.r[0]));
	assertEquals(
		"multiple storage r1",
		0,
		Calculator.evaluate("r0 = r1 = 1 + 1").compareTo(
			Calculator.r[1]));
	assertEquals("pow", 0,
		Calculator.evaluate("2 ^ 4").compareTo(new Fraction(16)));
	assertEquals("pow fractions", 0, Calculator.evaluate("1/2 ^ 4")
		.compareTo(new Fraction(1, 16)));
	// test for failure if spaces between operand and number (aside from
	// fractions) are forgotten
	try {
	    Calculator.evaluate("2*3");
	    fail("Forgotten spaces between operand and number");
	} catch (Exception e) {
	}
	// test for failure if expression does not make sense
	try {
	    Calculator.evaluate("2 + 3 +");
	    fail("Test is not proper syntax");
	} catch (Exception e) {
	}
	// test for failure if storing expression is not correct
	try {
	    Calculator.evaluate("r0 =");
	    fail("Incorrect usage of storage");
	} catch (Exception e) {
	}
	// test for failure if equal expression is not correct
	try {
	    Calculator.evaluate("r3= 43 - 1");
	    fail("improper spaces for storage");
	} catch (Exception e) {
	}
	// test for failure if not a storage element
	try {
	    Calculator.evaluate("r10 = 145");
	    fail("Not a proper storage element");
	} catch (Exception e) {
	}

    }

}
