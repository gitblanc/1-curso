/**
 * 
 */
package uo.mp.transaction.model.exceptions;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidIBANException extends InvalidTransactionException {

	/**
	 * 
	 */
	public InvalidIBANException() {
	}

	/**
	 * @param message
	 */
	public InvalidIBANException(String message) {
		super("IBAN de " + message + " no válido");
	}

	/**
	 * @param cause
	 */
	public InvalidIBANException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidIBANException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidIBANException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
