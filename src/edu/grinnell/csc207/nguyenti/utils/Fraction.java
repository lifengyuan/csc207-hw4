package edu.grinnell.csc207.nguyenti.utils;

import java.math.BigInteger;

/**
 * implementing fractions
 * 
 * @author Tiffany Nguyen
 * @author Earnest Wheeler
 * @author Matt Dole
 * @author Samuel A. Rebelsky
 * @author CSC207 2013F
 */

public class Fraction {

    // +------------------+---------------------------------------------
    // | Design Decisions |
    // +------------------+

    /*
     * Fractions are immutable. Once you've created one, it stays that way.
     * 
     * Fractions are arbitrary precision.
     * 
     * Denominators are always positive. Therefore, negative fractions are
     * represented with a negative numerator. Similarly, if a fraction has a
     * negative numerator, it is negative.
     * 
     * Fractions are stored in simplified form.
     */

    private static BigInteger NEGATIVE_ONE = BigInteger.valueOf(-1);

    // +--------+-------------------------------------------------------
    // | Fields |
    // +--------+

    /** The numerator of the fraction. Can be positive, zero or negative. */
    BigInteger numerator;

    /** The denominator of the fraction. Must be positive. */
    BigInteger denominator;

    // +--------------+-------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a new fraction equivalent to numerator/denominator.
     */
    public Fraction(BigInteger numerator, BigInteger denominator)
	    throws Exception {
	if (this.denominator.signum() == 0) {
	    throw new Exception("Zero is an invalid denominator");
	}
	this.numerator = numerator;
	this.denominator = denominator;
	this.cleanup();
    } // Fraction(BigInteger, BigInteger)

    public Fraction(int numerator, int denominator) throws Exception {
	if (this.denominator.signum() == 0) {
	    throw new Exception("Zero is an invalid denominator");
	}
	this.numerator = BigInteger.valueOf(numerator);
	this.denominator = BigInteger.valueOf(denominator);
	this.cleanup();

    } // Fraction(int, int)

    // +-------------------------+--------------------------------------
    // | Standard Object Methods |
    // +-------------------------+

    /**
     * Convert this fraction to a string for ease of printing.
     */
    public String toString() {
	return this.numerator + "/" + this.denominator;
    } // toString()

    // +-----------------+----------------------------------------------
    // | Private Methods |
    // +-----------------+

    /**
     * If the fraction is negative, make sure the numerator is negative and the
     * denominator is positive. If both the denominator and numerator are
     * negative, then make them both positive. The function then converts the
     * fraction to its simplest possible form
     */

    private void cleanup() {
	if (this.denominator.signum() < 0) {
	    this.denominator = this.denominator.abs();
	    if (this.numerator.signum() > 0) {
		this.numerator = this.numerator.multiply(NEGATIVE_ONE);
	    } else {
		this.numerator = this.numerator.abs();
	    }
	}
	this.simplify();
    }

    private void simplify() {
	BigInteger gcd = this.numerator.gcd(this.denominator);
	this.numerator = this.numerator.divide(gcd);
	this.denominator = this.denominator.divide(gcd);
    } // simplify()

    // +---------+------------------------------------------------------
    // | Methods |
    // +---------+

    /**
     * Add another fraction to this fraction.
     */
    public Fraction add(Fraction addend) throws Exception {
	BigInteger resultNumerator;
	BigInteger resultDenominator;

	// The denominator of the result is the
	// product of this object's denominator
	// and addMe's denominator
	resultDenominator = this.denominator.multiply(addend.denominator);
	// The numerator is more complicated
	resultNumerator = (this.numerator.multiply(addend.denominator))
		.add(addend.numerator.multiply(this.denominator));

	// Return the computed value
	Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
	resultFrac.simplify();
	return resultFrac;

    } // add(Fraction)

    public Fraction subtract(Fraction subtractor) throws Exception {
	subtractor.numerator = subtractor.numerator.multiply(NEGATIVE_ONE);
	return this.add(subtractor);
    }

    /**
     * Approximate this fraction as a double.
     */
    public double toDouble() {
	return this.numerator.doubleValue() / this.denominator.doubleValue();
    } // toDouble()

    /**
     * Multiply another fraction by this fraction
     */
    public Fraction multiplyBy(Fraction multiplier) {
	BigInteger resultNumerator;
	BigInteger resultDenominator;

	resultNumerator = this.numerator.multiply(multiplier.numerator);
	resultDenominator = this.denominator.multiply(multiplier.denominator);

	try {
	    Fraction resultFrac = new Fraction(resultNumerator,
		    resultDenominator);
	    resultFrac.simplify();
	    return resultFrac;
	} catch (Exception e1) {
	    // UHHHHHH
	    return this;
	}

    }

    /**
     * Divide this fraction by another fraction
     * 
     * @param divisor
     * @return
     * @throws Exception
     */

    public Fraction divideBy(Fraction divisor) throws Exception {
	BigInteger resultNumerator;
	BigInteger resultDenominator;

	resultNumerator = this.numerator.multiply(divisor.denominator);
	resultDenominator = this.denominator.multiply(divisor.numerator);

	Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
	resultFrac.simplify();
	return resultFrac;
    }

    /**
     * Find the fraction to the power of an integer
     * 
     * @param exponent
     * @return
     */

    public Fraction powerTo(int exponent) throws Exception {
	BigInteger resultNumerator;
	BigInteger resultDenominator;

	resultNumerator = this.numerator.pow(exponent);
	resultDenominator = this.denominator.pow(exponent);

	Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
	resultFrac.simplify();
	return resultFrac;
    }

} // class Fraction
