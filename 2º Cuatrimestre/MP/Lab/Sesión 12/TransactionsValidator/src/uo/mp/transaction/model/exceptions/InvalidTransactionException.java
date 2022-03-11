/**
 * 
 */
package uo.mp.transaction.model.exceptions;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidTransactionException extends Exception {

	/**
	 * 
	 */
	public InvalidTransactionException() {
	}

	/**
	 * @param message
	 */
	public InvalidTransactionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidTransactionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidTransactionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidTransactionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
