/**
 * 
 */
package uo.mp.transaction.model.exceptions;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidCreditNumberException extends InvalidTransactionException {

	/**
	 * 
	 */
	public InvalidCreditNumberException() {
	}

	/**
	 * @param message
	 */
	public InvalidCreditNumberException(String message) {
		super("Número de tarjeta de " + message + " no válido");
	}

	/**
	 * @param cause
	 */
	public InvalidCreditNumberException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidCreditNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidCreditNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
