/**
 * 
 */
package uo.mp.newsstand.service.exception;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class AlreadyExistsException extends NewsStandException {

	/**
	 * 
	 */
	public AlreadyExistsException() {
	
	}

	/**
	 * @param message
	 */
	public AlreadyExistsException(String message) {
		super("La publicacion " + message + " ya existe");
		
	}

	/**
	 * @param cause
	 */
	public AlreadyExistsException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
