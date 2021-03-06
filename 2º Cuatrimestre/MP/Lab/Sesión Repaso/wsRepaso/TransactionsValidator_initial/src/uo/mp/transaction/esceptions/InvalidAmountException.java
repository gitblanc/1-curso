/**
 * 
 */
package uo.mp.transaction.esceptions;

/**
 * @author blanc
 *
 */
public class InvalidAmountException extends InvalidTransactionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InvalidAmountException() {
	}

	/**
	 * @param message
	 */
	public InvalidAmountException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidAmountException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidAmountException(String message, Throwable cause) {
		super(message, cause);
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
	}

}
