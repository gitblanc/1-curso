package uo.mp.newsstand.service.parsers;

@SuppressWarnings("serial")
public class InvalidLineFormatException extends Exception {

	private int lineNumber;

	public InvalidLineFormatException(int ln, String msg) {
		super(msg);
		lineNumber = ln;
	}

	@Override
	public String getMessage() {
		return "Error en línea" + lineNumber + " " + getMessage();
	}
}
