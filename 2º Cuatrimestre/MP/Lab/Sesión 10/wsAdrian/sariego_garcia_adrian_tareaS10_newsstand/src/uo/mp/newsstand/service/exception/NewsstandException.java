package uo.mp.newsstand.service.exception;

@SuppressWarnings("serial")
public class NewsstandException extends Exception {

	public NewsstandException() {
		
	}

	public NewsstandException(String message) {
		super(message);
	}

	public NewsstandException(Throwable cause) {
		super(cause);

	}

	public NewsstandException(String message, Throwable cause) {
		super(message, cause);

	}

	public NewsstandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
