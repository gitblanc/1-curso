/**
 * 
 */
package uo.mp.newsstand.service;

/**
 * @author Antonio Castro
 *
 */
@SuppressWarnings("serial")
public class NewsStandException extends Exception {
	
private int lineNumber;
	
	
	public NewsStandException (int line, String msg) {
		super(msg);
		lineNumber = line;
	}
	
	
	@Override
	public String getMessage() {
		return "Error en línea " + lineNumber + ": " + super.getMessage();
	}

}
