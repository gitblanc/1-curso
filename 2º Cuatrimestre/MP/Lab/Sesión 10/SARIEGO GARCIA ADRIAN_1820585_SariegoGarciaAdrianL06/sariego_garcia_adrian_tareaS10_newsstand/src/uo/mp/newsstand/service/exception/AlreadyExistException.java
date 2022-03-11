package uo.mp.newsstand.service.exception;

@SuppressWarnings("serial")
public class AlreadyExistException extends NewsstandException {

	public AlreadyExistException() {

	}

	public AlreadyExistException(String message) {
		super("La publicacion " + message + " ya existe");

	}

	public AlreadyExistException(Throwable cause) {
		super(cause);
	
	}

	public AlreadyExistException(String message, Throwable cause) {
		super(message, cause);

	}

	public AlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
