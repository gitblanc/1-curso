/**
 * 
 */
package uo.mp.checks;

/**
 * @author Mari�n
 *
 */
public class ArgumentsCheck {
	
	/**
	 * Comprueba si la condici�n es correcta. Si no lo es, lanza una excepci�n
	 * de tipo IllegalArgumentException en la que se env�a el mensaje del 
	 * par�metro
	 * 
	 * @param condition
	 * @param msg
	 */
	public static void isTrue(boolean condition, String msg) {
		if (!condition) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Comprueba si la condici�n es correcta. Si no lo es, lanza una excepci�n
	 * de tipo IllegalArgumentException
	 * @param condition
	 */
	public static void isTrue(boolean condition) {
		if (!condition) {
			throw new IllegalArgumentException();
		}
	}
	

}
