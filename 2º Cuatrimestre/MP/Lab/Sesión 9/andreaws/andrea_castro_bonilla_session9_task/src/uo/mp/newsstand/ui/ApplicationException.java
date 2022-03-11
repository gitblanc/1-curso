package uo.mp.newsstand.ui;

@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	private String type;

	public ApplicationException(String t, String msg) {
		super(msg);
		type = t;
	}

	@Override
	public String getMessage() {
		return "Error: " + type + " " + getMessage();
	}
}
