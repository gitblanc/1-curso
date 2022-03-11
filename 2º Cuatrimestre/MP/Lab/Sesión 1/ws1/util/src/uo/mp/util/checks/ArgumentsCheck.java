/**
 * 
 */
package uo.mp.util.checks;

/**
 * @author blanc
 *
 */
public class ArgumentsCheck {
	
	public static void isTrue(boolean cond, String msg) {
		if (!cond) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void isTrue(boolean cond) {
		if (!cond) {
			throw new IllegalArgumentException();
		}
	}
}
