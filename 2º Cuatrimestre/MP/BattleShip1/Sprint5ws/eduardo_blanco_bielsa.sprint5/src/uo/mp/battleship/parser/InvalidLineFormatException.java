/**
 * 
 */
package uo.mp.battleship.parser;

/**
 * @author blanc
 *
 */
public class InvalidLineFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InvalidLineFormatException() {
	}

	/**
	 * @param message
	 */
	public InvalidLineFormatException(String message) {
		super("Error en la línea:" + message);
	}

	/**
	 * @param cause
	 */
	public InvalidLineFormatException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidLineFormatException(String message, Throwable cause) {
		super(message, cause);
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
	}

}
