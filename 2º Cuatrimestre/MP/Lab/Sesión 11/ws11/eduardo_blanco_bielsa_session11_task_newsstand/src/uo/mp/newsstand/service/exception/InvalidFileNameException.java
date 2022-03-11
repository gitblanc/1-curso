/**
 * 
 */
package uo.mp.newsstand.service.exception;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidFileNameException extends NewsStandException {

	/**
	 * 
	 */
	public InvalidFileNameException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InvalidFileNameException(String message) {
		super("El nombre del fichero " + message + " no es correcto");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InvalidFileNameException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidFileNameException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidFileNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
