/**
 * 
 */
package uo.mp.newsstand.ui;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	public ApplicationException(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return "Error: " + super.getMessage();
	}
}
