/**
 * 
 */
package uo.mp.newsstand.service.exception;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class NotExistsException extends NewsStandException {

	/**
	 * 
	 */
	public NotExistsException() {
	}

	/**
	 * @param message
	 */
	public NotExistsException(String message) {
		super("La publicacion " + message + " no existe");
	}

	/**
	 * @param cause
	 */
	public NotExistsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
