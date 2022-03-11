/**
 * 
 */
package uo.mp.newsstand.service.parsers;

/**
 * @author Antonio Castro
 *
 */
@SuppressWarnings("serial")
public class InvalidLineFormatException extends Exception {

	private int lineNumber;
	
	
	public InvalidLineFormatException (int line, String msg) {
		super(msg);
		lineNumber = line;
	}
	
	
	@Override
	public String getMessage() {
		return "Error en línea " + lineNumber + ": " + super.getMessage();
	}
}
