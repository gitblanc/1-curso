/**
 * 
 */
package uo.mp2021.util.checks;

/**
 * @author blanc
 *
 */
public class ArgumentChecks {
	
	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
	private static String NULL_MESSAGE = "Error: it was null ... ";
	private static String EMPTY_MESSAGE = "Error: it was empty ... ";
	private static String outputMessage = null;
	
	public static void isTrue ( boolean condition ) {
		outputMessage = DEFAULT_MESSAGE;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}

	public static void isTrue ( boolean condition, String message ) {
		outputMessage = message;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
	
	public static void isNotNull ( boolean condition ) {
		outputMessage = NULL_MESSAGE;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
	
	public static void isNotEmpty ( boolean condition ) {
		outputMessage = EMPTY_MESSAGE;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
}
