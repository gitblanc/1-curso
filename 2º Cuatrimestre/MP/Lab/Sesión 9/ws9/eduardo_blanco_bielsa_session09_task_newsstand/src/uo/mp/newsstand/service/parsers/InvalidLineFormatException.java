/**
 * 
 */
package uo.mp.newsstand.service.parsers;


/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class InvalidLineFormatException extends Exception {
	private int line;
	public InvalidLineFormatException(int ln, String msg) {
		super(msg);
		this.line = ln;
	}
	public int getLn() {
		return line;
	}
	@Override
	public String getMessage() {
		return "Error en línea " + this.line + ": " + super.getMessage();
	}
}
