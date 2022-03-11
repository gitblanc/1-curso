/**
 * 
 */
package uo.mp.transaction.model.exceptions;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidLineFormatException extends Exception {

	private int line;

	/**
	 * 
	 */
	public InvalidLineFormatException() {
		// TODO Auto-generated constructor stub
	}
	
	public InvalidLineFormatException(int ln, String msg) {
		super(msg);
		this.line = ln;
	}

	public int getLn() {
		return line;
	}
	/**
	 * @param cause
	 */
	public InvalidLineFormatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidLineFormatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidLineFormatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
