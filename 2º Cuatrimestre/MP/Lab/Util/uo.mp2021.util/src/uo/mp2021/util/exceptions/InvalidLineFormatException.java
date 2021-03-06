/**
 * 
 */
package uo.mp2021.util.exceptions;

/**
 * @author blanc
 *
 */
public class InvalidLineFormatException extends Exception {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lineNumber;

   
    public InvalidLineFormatException(int ln, String message) {
        super(message);
        lineNumber = ln;
    }

    
    @Override
    public String getMessage() {
        return "InvalidLineFormatException. L?nea " + lineNumber 
                + super.getMessage();
    }

}
