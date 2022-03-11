package uo.mp2021.util.checks;

public class ArgumentChecks {

	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
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
	
	/**
	 * Comprueba si la condicion es correcta. Si se lanza una excepción de tipo:
	 * IndexOutOfBoundsException
	 * 
	 * @param condition 
	 */
	public static void isTrueIndex ( boolean condition ) {
		if (!condition) 
			throw new IndexOutOfBoundsException(DEFAULT_MESSAGE);
	}
}
