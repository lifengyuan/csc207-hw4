package edu.grinnell.csc207.nguyenti.utils;

import java.math.BigInteger;

/**
 * Calculator implementation
 * 
 * @author Tiffany Nguyen
 * @author Earnest Wheeler
 * @author Matt Dole
 */

public class Calculator {

    Fraction ZERO_FRACTION = new Fraction(0);
    // r is an array of 10 fractions, each initialized as Fraction(0)
    Fraction[] r = { ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION,
	    ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION,
	    ZERO_FRACTION, ZERO_FRACTION, ZERO_FRACTION };

    // HAVENT DEALT WITH "r0 =" case
    public Fraction evaluate(String expression) throws Exception {
	String[] vals = expression.split(" ");
	String revised = "";
	int len = vals.length;
	Fraction total;
	char c = vals[0].charAt(0);
	Fraction left;
	int j = 0;
	Fraction right;
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
	    left = new Fraction(vals[0]);
	    
	    while(j < len) {
		j++;
		if (vals[j - 1].length() != 1) {
		    throw new Exception(vals[j] + " is not a valid operation");
		}
		
		switch (vals[j - 1].charAt(0)) {
		case '+': left = left.add(BigInteger.valueOf(right));
		break;
		case '-': result = result.subtract(BigInteger.valueOf(right));
		break;
		case '*': result = result.multiply(BigInteger.valueOf(right));
		break;
		case '/': result = result.divide(BigInteger.valueOf(right));
		break;
		case '^': result = result.pow(right);
		break;
		default:  
		break;
		}
		
	    }
	}
	return null;
    }
}
