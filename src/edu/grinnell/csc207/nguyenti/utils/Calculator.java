package edu.grinnell.csc207.nguyenti.utils;

public class Calculator {

    String[] r = new String[9];

    public Fraction evaluate(String expression) throws Exception {
	String[] vals = expression.split(" ");
	Fraction total;
	if (!Character.isDigit(vals[0].charAt(0))) {
	    throw new Exception("NOT A DIGIT, FOoL");
	}
	for (int i = 0; i < vals.length; i++) {
	    for (int j = 0; j < vals[i].length(); j++) {
		
	    }
	}
	return null;
    }
}
