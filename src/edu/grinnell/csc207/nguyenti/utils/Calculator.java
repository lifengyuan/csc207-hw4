package edu.grinnell.csc207.nguyenti.utils;

import java.math.BigInteger;

/**
 * Calculator implementation
 * 
 * @author Tiffany Nguyen
 * @author Earnest Wheeler
 * @author Matt Dole
 * 
 *         The switch statement for operations in evaluate is taken from
 *         edu.grinnell.csc207.wheelere.hw3.Calculator.java, available at
 *         https://github.com/wheelere/csc207-hw3/blob/master/
 *         csc207-hw3/src/edu/grinnell/csc207/wheelere/hw3/ Calculator.java
 * 
 * 
 */

public class Calculator {

	Fraction ZERO_FRACTION = new Fraction(0);
	// r is an array of 10 fractions, each initialized as Fraction(0)
	Fraction[] r = { ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION,
			ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION,
			ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION };

	// HAVENT DEALT WITH "r0 =" case
	// If we want make error index work properly, we need to have a set count
	// that will survive recursion
	public Fraction evaluate(String expression) throws Exception {
		String[] vals = expression.split(" ");
		String revised = "";
		int len = vals.length;
		char c = vals[0].charAt(0);
		Fraction right;
		Fraction result;
		if (!Character.isDigit(c) && c != 'r') {
			throw new Exception(vals[0]
					+ " is not a digit or a storage element");
		} else if (vals[1] == "=") {
			if (c != 'r') {
				throw new Exception(vals[0] + " is not a storage element");
			} else if (vals[0].length() > 2
					&& !Character.isDigit(vals[0].charAt(1))) {
				throw new Exception(vals[0]
						+ " is not a proper storage element");
			} else {
				for (int i = 2; i < len; i++) {
					revised = revised + vals[i] + " "; // Worth checking
				}
				r[vals[0].charAt(1)] = evaluate(revised);
				return r[vals[0].charAt(1)];
			}
		} else {
			result = new Fraction(vals[0]);
			for (int j = 2; j < len; j += 2) {

				if (vals[j - 1].length() != 1) {
					throw new Exception(vals[j] + " is not a valid operation");
				}
				right = new Fraction(vals[j]);
				switch (vals[j - 1].charAt(0)) {
				case '+':
					result = result.add(right);
					break;
				case '-':
					result = result.subtract(right);
					break;
				case '*':
					result = result.multiplyBy(right);
					break;
				case '/':
					result = result.divideBy(right);
					break;
				case '^':
					if (right.wholePart() == right.numerator()) {
						result = result.pow(Integer.parseInt(vals[j]));
					} else {
						throw new Exception("Term beginning at index " + j
								+ " must be an integer value");
					}
					break;
				default:
					throw new Exception(vals[j] + " is not a valid operation");
				}
			} // for loop calculates everything and condenses it into result
			return result;
		}
	}
}
