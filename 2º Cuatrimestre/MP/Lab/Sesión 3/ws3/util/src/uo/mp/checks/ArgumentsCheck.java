/**
 * 
 */
package uo.mp.checks;

/**
 * @author Marián
 *
 */
public class ArgumentsCheck {
	
	/**
	 * Comprueba si la condición es correcta. Si no lo es, lanza una excepción
	 * de tipo IllegalArgumentException en la que se envía el mensaje del 
	 * parámetro
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
	 * Comprueba si la condición es correcta. Si no lo es, lanza una excepción
	 * de tipo IllegalArgumentException
	 * @param condition
	 */
	public static void isTrue(boolean condition) {
		if (!condition) {
			throw new IllegalArgumentException();
		}
	}
	

}
