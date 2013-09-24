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
 *         I sat next to Daniel Goldstein while writing evaluate ~
 * 
 */

public class Calculator {
	private static int BadIndex = 0;
	static Fraction ZERO_FRACTION = new Fraction(0);
<<<<<<< HEAD

=======
>>>>>>> 60f2fea1f577bdc155ea957cb3ab854512dec736
	// r is an array of 10 fractions, each initialized as Fraction(0)
	static Fraction[] r = { ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION,
			ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION,
			ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION };

	// HAVENT DEALT WITH "r0 =" case
	// If we want make error index work properly, we need to have a set count
	// that will survive recursion
	public static Fraction evaluate(String expression) throws Exception {
		// Create an array of the terms and the operations
		String[] vals = expression.split(" ");
		String revised = ""; // An empty string
		int len = vals.length; // the number of terms + operations
		if (len == 0) {
			throw new Exception("Location: " + BadIndex + "Nothing to compute");
		}
		Fraction result; // the left side of the equation and the final result
		Fraction right; // the right term that the operation is applying
		char c = vals[0].charAt(0); // the first character of expression
		// Check if the first character isnt a number or r:
		if (!Character.isDigit(c) && c != 'r') {
			throw new Exception("Location: " + BadIndex + "; " + vals[0]
					+ " is not a digit or a storage element");
		} else if (len > 1 && vals[1] == "=") {
			// if the first operation is '=', we should be assigning rN a value
			if (c != 'r') {
				throw new Exception("Location: " + BadIndex + "; " + vals[0]
						+ " is not a storage element");
			} else if (vals[0].length() != 2
					&& !Character.isDigit(vals[0].charAt(1))) {
				// if we have rNN, or r[non-digit], throw this exception
				throw new Exception("Location: " + BadIndex + "; " + vals[0]
						+ " is not a proper storage element");
			} else {

				// if everything checks out, make revised everything after '='
				for (int i = 2; i < len; i++) {
					revised = revised + vals[i] + " ";
				}
				BadIndex += 5; // set the index to be after 'rN = '
				// recurse with revised, and set rN to be evaluate(revised)
				r[vals[0].charAt(1)] = evaluate(revised);
				return r[vals[0].charAt(1)];
			}
		} else {
			/**
			 * If there isn't an equals as the first operation, there should
			 * never be one and we can move on to calculating everything.
			 */

			// Check for the first term being rN
			if (c == 'r') {
				// ensure it's a valid storage element
				if (Character.isDigit(vals[0].charAt(1))
						&& vals[0].length() == 2) {
					// set result as the given storage element
					result = r[vals[0].charAt(1)];
				} else {
					throw new Exception("Location: " + BadIndex + "; "
							+ vals[0] + " is not a proper storage element");
				}
			} else {
				// otherwise set result to be Fraction(String) of the first term
				try {
					result = new Fraction(vals[0]);
				} catch (Exception e) {
					// throw exception if it's not a valid string
					throw new Exception("Location: " + BadIndex + "; "
							+ vals[0] + " is not a fraction");
				}
			}

			BadIndex = BadIndex + (vals[0].length());
			int j;
			// we increment by 2, so we are hitting only the terms
			for (j = 2; j < len; j += 2) {
				BadIndex += 3;

				// Check if the operation term is more than 1 character
				if (vals[j - 1].length() != 1) {
					throw new Exception("Location: " + (BadIndex - 2) + "; "
							+ vals[j - 1] + " is not a valid operation");
				}
				// check for a storage element
				if (vals[j].charAt(0) == 'r') {
					// check if its a proper storage element
					if (Character.isDigit(vals[0].charAt(1))
							&& vals[0].length() == 2) {
						// set right to be that storage element
						right = r[vals[0].charAt(1)];
					} else {
						throw new Exception("Location: " + BadIndex + "; "
								+ vals[0] + " is not a proper storage element");
					}
				} else {
					// set right to be Fraction(String) of the next term
					try {
						right = new Fraction(vals[j]);
					} catch (Exception e) {
						// if its not a string of a fraction throw an exception
						throw new Exception("Location: " + BadIndex + "; "
								+ vals[j] + " is not a fraction");
					}
				}
				// We know vals[j -1] should be an operation, and is 1 char long
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
					// We can only take integer exponents
					if (right.wholePart() == right.numerator()) {
						result = result.pow(Integer.parseInt(vals[j]));
					} else {
						throw new Exception("Location: " + BadIndex + "; "
								+ vals[j] + " must be an integer value");
					}
					break;
				default:
					// If we don't have one of these operations, we reject it
					throw new Exception("Location: " + (BadIndex - 2) + "; "
							+ vals[j - 1] + " is not a valid operation");
				}
				BadIndex += vals[j].length();
			} // for loop calculates everything and condenses it into result

			/**
			 * Since we are incrementing by 2, we need to check that there isn't
			 * a stray term or operation at the end of the expression.
			 */
			if (len != j) {
				throw new Exception("Location: " + (BadIndex + 2) + "; "
						+ vals[len] + " is not valid syntax");
			}

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
			if (expression.compareTo("quit") == 0
					|| expression.compareTo("Quit") == 0) {
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
