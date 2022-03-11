/**
 * 
 */
package uo.mp.transaction.model.exceptions;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidMaxAmountException extends InvalidTransactionException {

	/**
	 * 
	 */
	public InvalidMaxAmountException() {
	}

	/**
	 * @param message
	 */
	public InvalidMaxAmountException(String message) {
		super("Importe cobrado de " + message + " mayor que el máximo permitido");
	}

	/**
	 * @param cause
	 */
	public InvalidMaxAmountException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidMaxAmountException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidMaxAmountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
