/**
 * 
 */
package uo.mp.battleship.util.exceptions;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidOptionException extends Exception {

	/**
	 * 
	 */
	public InvalidOptionException() {
	}

	/**
	 * @param message
	 */
	public InvalidOptionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidOptionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidOptionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidOptionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
