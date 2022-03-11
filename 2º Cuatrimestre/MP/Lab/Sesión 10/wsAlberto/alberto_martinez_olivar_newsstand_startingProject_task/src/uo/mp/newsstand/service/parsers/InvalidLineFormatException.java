package uo.mp.newsstand.service.parsers;

@SuppressWarnings("serial")
public class InvalidLineFormatException extends Exception {
	
	private int lineNumber;
	private String msg;
	
	public InvalidLineFormatException(int ln, String msg) {
		super(msg);
		lineNumber = ln;
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return "Error en linea " + lineNumber + ": " + msg;
	}
}
