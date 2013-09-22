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
	Fraction right;
	boolean operation = false;
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
	    }
	} else {
	    for (int j = 0; j < len; j++) {
		if(vals[j].length() == 1) {
		    switch (vals[j].charAt(0)) {
		    case '+':
		    case '-':
		    case '*':
		    case '/':
		    case '^': 
			operation = true;
		    break;	
		    default:  
			operation = false;
		    break;
		    }
		}
		if(!operation) {
		    left = Fraction(vals[j]);
		}
		c = vals[j].charAt[0]
	    }
	}
	return null;
    }
}
