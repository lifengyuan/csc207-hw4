package edu.grinnell.csc207.nguyenti.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	private static int BadIndex = 0;
	static Fraction ZERO_FRACTION = new Fraction(0);
	// r is an array of 10 fractions, each initialized as Fraction(0)
	static Fraction[] r = { ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION,
			ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION,
			ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION };

	// HAVENT DEALT WITH "r0 =" case
	// If we want make error index work properly, we need to have a set count
	// that will survive recursion
	public static Fraction evaluate(String expression) throws Exception {
		String[] vals = expression.split(" ");
		String revised = "";
		int len = vals.length;
		char c = vals[0].charAt(0);
		Fraction right;
		Fraction result;
		if (!Character.isDigit(c) && c != 'r') {
			throw new Exception("Location: " + BadIndex + "; " + vals[0]
					+ " is not a digit or a storage element");
		} else if (vals[1] == "=") {
			if (c != 'r') {
				throw new Exception("Location: " + BadIndex + "; " + vals[0]
						+ " is not a storage element");
			} else if (vals[0].length() > 2
					&& !Character.isDigit(vals[0].charAt(1))) {
				throw new Exception("Location: " + BadIndex + "; " + vals[0]
						+ " is not a proper storage element");
			} else {
				for (int i = 2; i < len; i++) {
					revised = revised + vals[i] + " "; // Worth checking
				}
				BadIndex += 2;
				r[vals[0].charAt(1)] = evaluate(revised);
				return r[vals[0].charAt(1)];
			}
		} else {
			if (vals[0].charAt(0) == 'r') {
				if (Character.isDigit(vals[0].charAt(1))
						&& vals[0].length() == 2) {
					result = r[vals[0].charAt(1)];
				} else {
					throw new Exception("Location: " + BadIndex + "; "
							+ vals[0] + " is not a proper storage element");
				}

			}
			result = new Fraction(vals[0]);
			for (int j = 2; j < len; j += 2) {

				if (vals[j - 1].length() != 1) {
					throw new Exception(vals[j] + " is not a valid operation");
				}
				if (vals[j].charAt(0) == 'r') {

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

	
	
	public static void main(String[] args) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		InputStreamReader istream = new InputStreamReader(System.in);
		BufferedReader eyes = new BufferedReader(istream);
		String expression = "";
		//Fraction output;
		boolean loopchecker = true;

		pen.println("Welcome to the M.E.T. calculator!");
		pen.println("You can enter a mathematical expression using +, -, *, / and ^.");
		pen.println("You can only use fractions (in the form of \"x/y\" with no spaces) and integers.");
		pen.println("Expressions are expected to have spaces between numbers/fractions and operands.");
		pen.println("If you want to store a result, type in \"rn = \" where n = [0-9]\n");
		pen.println("All storage elements are initially set to 0");
		while (loopchecker) {
			pen.println("Enter an expression or \"Quit\" to exit the calculator: ");
			expression = eyes.readLine();
			if (expression.compareTo("quit") == 0 || expression.compareTo("Quit") == 0) {
				pen.println("Program terminated");
				loopchecker = false; // check this
			} else {
				try {
					//output = evaluate(expression);
					//pen.println("Your output is: \n" + output.toString());
					BadIndex = 0;
				} catch (Exception e) {
					pen.println("ERROR\n" + e.getMessage());
				}
			}
		}
	}

}
