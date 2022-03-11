/**
 * 
 */
package uo.mp.transaction.model.exceptions;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidDateException extends InvalidTransactionException {

	/**
	 * 
	 */
	public InvalidDateException() {
	}

	/**
	 * @param message
	 */
	public InvalidDateException(String message) {
		super("Fecha de operación de " + message + " no válida");
	}

	/**
	 * @param cause
	 */
	public InvalidDateException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidDateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidDateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
