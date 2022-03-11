/**
 * 
 */
package uo.mp.newsstand.service.exception;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class NewsStandException extends Exception {

	/**
	 * 
	 */
	public NewsStandException() {
		
	}

	/**
	 * @param message
	 */
	public NewsStandException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public NewsStandException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NewsStandException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NewsStandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
