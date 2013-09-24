package edu.grinnell.csc207.nguyenti.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class FractionTest {

    @Test
    public void testZeroDenominator() {
	try {
	    new Fraction(1, 0);
	    fail("Zero denominator did not throw an exception");
	} catch (Exception e) {
	}
    }

    // The constructor tests use the compareTo method, testing that
    // the method works properly while testing if the constructors
    // work.

    @Test
    public void testFractionIntInt() throws Exception {
	assertEquals("Numerator and denominator are small positive numbers", 0,
		new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(6))
			.compareTo(new Fraction(1, 6)));
	assertEquals("Numerator and denominator are negative", 0,
		new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(6))
			.compareTo(new Fraction(-1, -6)));
	assertEquals("Numerator is negative, denominator is positive", 0,
		new Fraction(BigInteger.valueOf(-1), BigInteger.valueOf(6))
			.compareTo(new Fraction(-1, 6)));
	assertEquals("Numerator is positive, denominator is negative", 0,
		new Fraction(BigInteger.valueOf(-1), BigInteger.valueOf(6))
			.compareTo(new Fraction(1, -6)));
	assertEquals(
		"Numerator and denominator are large positive numbers",
		0,
		new Fraction(BigInteger.valueOf(Integer.MAX_VALUE), BigInteger
			.valueOf(Integer.MAX_VALUE - 10))
			.compareTo(new Fraction(Integer.MAX_VALUE,
				Integer.MAX_VALUE - 10)));
	assertEquals(
		"Numerator and denominator are large negative numbers",
		0,
		new Fraction(BigInteger.valueOf(Integer.MIN_VALUE), BigInteger
			.valueOf(Integer.MIN_VALUE + 10))
			.compareTo(new Fraction(Integer.MIN_VALUE,
				Integer.MIN_VALUE + 10)));
	assertEquals(
		"Numerator is a large positive number, denominator is a large negative number",
		0, new Fraction(BigInteger.valueOf(Integer.MAX_VALUE),
			BigInteger.valueOf(Integer.MIN_VALUE))
			.compareTo(new Fraction(Integer.MAX_VALUE,
				Integer.MIN_VALUE)));
	assertEquals("Numerator is a large positive number, denominator is 1",
		0, new Fraction(BigInteger.valueOf(Integer.MAX_VALUE),
			BigInteger.valueOf(1)).compareTo(new Fraction(
			Integer.MAX_VALUE, 1)));
	assertEquals("Numerator is a large negative number, denominator is 1",
		0, new Fraction(BigInteger.valueOf(Integer.MIN_VALUE),
			BigInteger.valueOf(1)).compareTo(new Fraction(
			Integer.MIN_VALUE, 1)));

    }

    @Test
    public void testFractionBigInteger() throws Exception {
	assertEquals("Numerator is a small positive", 0,
		new Fraction(BigInteger.valueOf(6), BigInteger.valueOf(1))
			.compareTo(new Fraction(BigInteger.valueOf(6))));
	assertEquals(
		"Numerator is a large positive",
		0,
		new Fraction(BigInteger.valueOf(Integer.MAX_VALUE), BigInteger
			.valueOf(1)).compareTo(new Fraction(BigInteger
			.valueOf(Integer.MAX_VALUE))));
	assertEquals("Numerator is a small negative", 0,
		new Fraction(BigInteger.valueOf(-6), BigInteger.valueOf(1))
			.compareTo(new Fraction(BigInteger.valueOf(-6))));
	assertEquals(
		"Numerator is a large negative",
		0,
		new Fraction(BigInteger.valueOf(Integer.MIN_VALUE), BigInteger
			.valueOf(1)).compareTo(new Fraction(BigInteger
			.valueOf(Integer.MIN_VALUE))));
    }

    @Test
    public void testFractionInt() throws Exception {
	assertEquals("Numerator is a small positive", 0,
		new Fraction(BigInteger.valueOf(6), BigInteger.valueOf(1))
			.compareTo(new Fraction(6)));
	assertEquals(
		"Numerator is a large positive",
		0,
		new Fraction(BigInteger.valueOf(Integer.MAX_VALUE), BigInteger
			.valueOf(1)).compareTo(new Fraction(Integer.MAX_VALUE)));
	assertEquals("Numerator is a small negative", 0,
		new Fraction(BigInteger.valueOf(-6), BigInteger.valueOf(1))
			.compareTo(new Fraction(-6)));
	assertEquals(
		"Numerator is a large negative",
		0,
		new Fraction(BigInteger.valueOf(Integer.MIN_VALUE), BigInteger
			.valueOf(1)).compareTo(new Fraction(Integer.MIN_VALUE)));
    }

    @Test
    public void testFractionString() throws Exception {
	assertEquals("Numerator and denominator are small positive numbers", 0,
		new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(6))
			.compareTo(new Fraction("1/6")));
	assertEquals("Numerator and denominator are negative", 0,
		new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(6))
			.compareTo(new Fraction("-1/-6")));
	assertEquals("Numerator is negative, denominator is positive", 0,
		new Fraction(BigInteger.valueOf(-1), BigInteger.valueOf(6))
			.compareTo(new Fraction("-1/6")));
	assertEquals("Numerator is positive, denominator is negative", 0,
		new Fraction(BigInteger.valueOf(-1), BigInteger.valueOf(6))
			.compareTo(new Fraction("1/-6")));
	assertEquals("Numerator is positive, no denominator", 0,
		new Fraction(BigInteger.valueOf(8), BigInteger.valueOf(1))
			.compareTo(new Fraction("8")));
	assertEquals("Numerator is negative, no denominator", 0,
		new Fraction(BigInteger.valueOf(-8), BigInteger.valueOf(1))
			.compareTo(new Fraction("-8")));
    }

    @Test
    public void testFractionLongLong() throws Exception {
	assertEquals("Numerator and denominator are small positive numbers", 0,
		new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(6))
			.compareTo(new Fraction((long) 1, (long) 6)));
	assertEquals("Numerator and denominator are negative", 0,
		new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(6))
			.compareTo(new Fraction((long) -1, (long) -6)));
	assertEquals("Numerator is negative, denominator is positive", 0,
		new Fraction(BigInteger.valueOf(-1), BigInteger.valueOf(6))
			.compareTo(new Fraction((long) -1, (long) 6)));
	assertEquals("Numerator is positive, denominator is negative", 0,
		new Fraction(BigInteger.valueOf(-1), BigInteger.valueOf(6))
			.compareTo(new Fraction((long) 1, (long) -6)));
	assertEquals(
		"Numerator and denominator are large positive numbers",
		0,
		new Fraction(BigInteger.valueOf(Integer.MAX_VALUE), BigInteger
			.valueOf(Integer.MAX_VALUE - 10))
			.compareTo(new Fraction((long) Integer.MAX_VALUE,
				(long) Integer.MAX_VALUE - 10)));
	assertEquals(
		"Numerator and denominator are large negative numbers",
		0,
		new Fraction(BigInteger.valueOf(Integer.MIN_VALUE), BigInteger
			.valueOf(Integer.MIN_VALUE + 10))
			.compareTo(new Fraction((long) Integer.MIN_VALUE,
				(long) Integer.MIN_VALUE + 10)));
	assertEquals(
		"Numerator is a large positive number, denominator is a large negative number",
		0, new Fraction(BigInteger.valueOf(Integer.MAX_VALUE),
			BigInteger.valueOf(Integer.MIN_VALUE))
			.compareTo(new Fraction((long) Integer.MAX_VALUE,
				(long) Integer.MIN_VALUE)));
	assertEquals("Numerator is a large positive number, denominator is 1",
		0, new Fraction(BigInteger.valueOf(Integer.MAX_VALUE),
			BigInteger.valueOf(1)).compareTo(new Fraction(
			(long) Integer.MAX_VALUE, (long) 1)));
	assertEquals("Numerator is a large negative number, denominator is 1",
		0, new Fraction(BigInteger.valueOf(Integer.MIN_VALUE),
			BigInteger.valueOf(1)).compareTo(new Fraction(
			(long) Integer.MIN_VALUE, (long) 1)));
    }

    @Test
    public void testFractionDouble() throws Exception {
	assertEquals("Numerator is a small positive", 0,
		new Fraction(BigInteger.valueOf(6), BigInteger.valueOf(1))
			.compareTo(new Fraction(6.0)));
	assertEquals(
		"Numerator is a large positive",
		0,
		new Fraction(BigInteger.valueOf(Integer.MAX_VALUE), BigInteger
			.valueOf(1)).compareTo(new Fraction(
			(double) Integer.MAX_VALUE)));
	assertEquals("Numerator is a small negative", 0,
		new Fraction(BigInteger.valueOf(-6), BigInteger.valueOf(1))
			.compareTo(new Fraction((double) -6)));
	assertEquals(
		"Numerator is a large negative",
		0,
		new Fraction(BigInteger.valueOf(Integer.MIN_VALUE), BigInteger
			.valueOf(1)).compareTo(new Fraction(
			(double) Integer.MIN_VALUE)));
	assertEquals("Small non-integer double", 0,
		new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(2))
			.compareTo(new Fraction(2.5)));
	assertEquals("Negative non-integer double", 0,
		new Fraction(BigInteger.valueOf(-5), BigInteger.valueOf(2))
			.compareTo(new Fraction(-2.5)));
	assertEquals("longer double", 0, new Fraction(BigInteger.valueOf((long) 5.5737296))
			.compareTo(new Fraction(55737296/10000000)));
    }

    @Test
    public void testToString() throws Exception {
	assertEquals("basic fraction", "1/6", new Fraction(1, 6).toString());
	assertEquals("negative fraction", "-5/4",
		new Fraction(-5, 4).toString());
    }

    @Test
    public void testHashCode() throws Exception {
	assertEquals("Two BigInts as input", new Fraction(
		BigInteger.valueOf(5), BigInteger.valueOf(3)).hashCode(),
		new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(3))
			.hashCode());
	assertEquals("Two ints as input", new Fraction(12, 5).hashCode(),
		new Fraction(12, 5).hashCode());
	assertEquals("Two strings as input", new Fraction("-72/16").hashCode(),
		new Fraction("-72/16").hashCode());
    }

    @Test
    public void testClone() throws Exception {
	assertEquals("negative fraction", 0, new Fraction(-5, -2).clone()
		.compareTo(new Fraction(-5, -2)));
	assertEquals("basic fraction", 0,
		new Fraction(2, 3).clone().compareTo(new Fraction(2, 3)));
	assertEquals(
		"big input",
		0,
		new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE).clone()
			.compareTo(
				new Fraction(Integer.MIN_VALUE,
					Integer.MAX_VALUE)));
    }

    @Test
    public void testEqualsFraction() throws Exception {
	assertEquals("negative fraction", true,
		new Fraction(-4).equals(new Fraction(-4)));
	assertEquals("basic fraction", true,
		new Fraction(7, 5).equals(new Fraction(7, 5)));
	assertEquals("big input", true, new Fraction(Integer.MIN_VALUE,
		Integer.MAX_VALUE).equals(new Fraction(Integer.MIN_VALUE,
		Integer.MAX_VALUE)));
    }

    @Test
    public void testAdd() throws Exception {
	assertEquals("basic fractions", 0, new Fraction(6)
		.add(new Fraction(-2)).compareTo(new Fraction(4)));
	assertEquals(
		"negative fractions",
		0,
		new Fraction(-4, 2).add(new Fraction(-1, 2)).compareTo(
			new Fraction(-5, 2)));
    }

    @Test
    public void testSubtract() throws Exception {
	assertEquals(
		"basic fractions",
		0,
		new Fraction(6).subtract(new Fraction(-2)).compareTo(
			new Fraction(8)));
	assertEquals(
		"negative fractions",
		0,
		new Fraction(-4, 5).subtract(new Fraction(1, 5)).compareTo(
			new Fraction(-1)));
    }

    @Test
    public void testToDouble() throws Exception {
	assertEquals("basic fractions", 2.5, new Fraction(5, 2).toDouble(),
		.001);
	assertEquals("negative fractions", -4.0, new Fraction(-8, 2).toDouble(),
		.001);
    }

    @Test
    public void testToBigDecimal() throws Exception {
	assertEquals("basic fraction", 0, new Fraction(13, 4).toBigDecimal()
		.compareTo(new BigDecimal(3.25)));
	assertEquals("basic fraction", 0, new Fraction(-3, 4).toBigDecimal()
		.compareTo(new BigDecimal(-.75)));
    }

    @Test
    public void testMultiplyBy() throws Exception {
	assertEquals(
		"basic fraction",
		0,
		new Fraction(2).multiplyBy(new Fraction(3)).compareTo(
			new Fraction(6)));
	assertEquals(
		"negative fraction",
		0,
		new Fraction(-2, 3).multiplyBy(new Fraction(4, 5)).compareTo(
			new Fraction(-8, 15)));
	assertEquals("big numbers", -1,
		new Fraction(Integer.MAX_VALUE).multiplyBy(new Fraction(2))
			.compareTo(new Fraction(Long.MAX_VALUE)));
    }

    @Test
    public void testDivideBy() throws Exception {
	assertEquals(
		"basic fraction",
		0,
		new Fraction(6).divideBy(new Fraction(3)).compareTo(
			new Fraction(2)));
	assertEquals(
		"negative fraction",
		0,
		new Fraction(-4).divideBy(new Fraction(-7)).compareTo(
			new Fraction(4, 7)));
	assertEquals(
		"negative fraction part 2",
		0,
		new Fraction(-2, 5).divideBy(new Fraction(-4, 10)).compareTo(
			new Fraction(1)));
    }

    @Test
    public void testPow() throws Exception {
	assertEquals("basic fraction", 0,
		new Fraction(4).pow(2).compareTo(new Fraction(16)));
	assertEquals("negative fraction", 0,
		new Fraction(-4).pow(2).compareTo(new Fraction(16)));
	assertEquals("negative exponent, positive base", 0,
		new Fraction(4).pow(-2).compareTo(new Fraction(1, 16)));
	assertEquals("negative exponent, negative base", 0,
		new Fraction(-4).pow(-2).compareTo(new Fraction(1, 16)));
	assertEquals("big input", 0,
		new Fraction(1000).pow(2).compareTo(new Fraction(BigInteger.valueOf(1000000))));
	
    }

    @Test
    public void testReciprocal() throws Exception {
	assertEquals("basic fraction", 0, new Fraction(5, 4).reciprocal()
		.compareTo(new Fraction(4, 5)));
	assertEquals("negative fraction", 0, new Fraction(-5, 4).reciprocal()
		.compareTo(new Fraction(-4, 5)));
	assertEquals("big input", 0, new Fraction(Integer.MAX_VALUE, 5).reciprocal()
		.compareTo(new Fraction(5, Integer.MAX_VALUE)));
    }

    @Test
    public void testNegate() throws Exception {
	assertEquals("basic fraction", 0,
		new Fraction(5).negate().compareTo(new Fraction(-5)));
	assertEquals("negative fraction", 0,
		new Fraction(-5).negate().compareTo(new Fraction(5)));
	assertEquals("big input", 0,
		new Fraction(Integer.MAX_VALUE).negate().compareTo(new Fraction(Integer.MIN_VALUE+1)));
    }

    @Test
    public void testNumerator() throws Exception {
	assertEquals("basic fraction", BigInteger.valueOf(2), new Fraction(2,
		15).numerator());
	assertEquals("negative fraction", BigInteger.valueOf(-2), new Fraction(-2,
		45).numerator());
	assertEquals("big input", BigInteger.valueOf(Integer.MAX_VALUE), new Fraction(Integer.MAX_VALUE, 2).numerator());
    }

    @Test
    public void testDenominator() throws Exception {
	assertEquals("basic fraction", BigInteger.valueOf(45), new Fraction(2,
		45).denominator());
	assertEquals("negative fraction", BigInteger.valueOf(45), new Fraction(
		-2, 45).denominator());
	assertEquals("big input", BigInteger.valueOf(Integer.MAX_VALUE),
		new Fraction(2, Integer.MAX_VALUE).denominator());
    }

    @Test
    public void testFractionalPart() throws Exception {
	assertEquals("basic fraction", 0, new Fraction(7, 2).fractionalPart()
		.compareTo(new Fraction(1, 2)));
	assertEquals("fractional part is 0", 0, new Fraction(1)
		.fractionalPart().compareTo(new Fraction(0)));
	assertEquals("whole part is 0", 0, new Fraction(1, 2).fractionalPart()
		.compareTo(new Fraction(1, 2)));
    }

    @Test
    public void testWholePart() throws Exception {
	assertEquals("basic fraction", BigInteger.valueOf(3),
		new Fraction(7, 2).wholePart());
	assertEquals("whole number", BigInteger.valueOf(5),
		new Fraction(5).wholePart());
	assertEquals("big whole number", BigInteger.valueOf(Integer.MAX_VALUE),
		new Fraction(Integer.MAX_VALUE).wholePart());
	assertEquals("fraction with no remainder", BigInteger.valueOf(3),
		new Fraction(6, 2).wholePart());
	assertEquals("negative fraction", BigInteger.valueOf(-3), new Fraction(
		-7, 2).wholePart());
	assertEquals("negative whole", BigInteger.valueOf(-3),
		new Fraction(-3).wholePart());

    }
}
