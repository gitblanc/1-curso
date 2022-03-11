/**
 * 
 */
package uo.mp2021.util.checks;

import java.util.NoSuchElementException;

/**
 * @author blanc
 *
 */
public class NoSuchElementChecks {
	public static void isTrue(boolean condition, String msg) {
        if(!condition) {
            throw new NoSuchElementException(msg);
        }
    }
}
