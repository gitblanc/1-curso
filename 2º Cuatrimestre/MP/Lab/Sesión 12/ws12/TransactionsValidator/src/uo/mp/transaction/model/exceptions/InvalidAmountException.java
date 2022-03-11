/**
 * 
 */
package uo.mp.transaction.model.exceptions;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidAmountException extends InvalidTransactionException {

	/**
	 * 
	 */
	public InvalidAmountException() {
	}

	/**
	 * @param message
	 */
	public InvalidAmountException(String message) {
		super("Transacción de " + message + " por encima de los 1000€");
	}

	/**
	 * @param cause
	 */
	public InvalidAmountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidAmountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidAmountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
