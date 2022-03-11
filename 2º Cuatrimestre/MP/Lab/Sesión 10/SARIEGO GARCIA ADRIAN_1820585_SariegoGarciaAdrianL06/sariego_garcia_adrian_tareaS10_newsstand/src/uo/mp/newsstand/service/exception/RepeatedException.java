/**
 * 
 */
package uo.mp.newsstand.service.exception;

/**
 * @author adrian
 *
 */
@SuppressWarnings("serial")
public class RepeatedException extends Exception {
	public RepeatedException() {
	}

	public RepeatedException(String msg) {
		super(msg);
	}
}
