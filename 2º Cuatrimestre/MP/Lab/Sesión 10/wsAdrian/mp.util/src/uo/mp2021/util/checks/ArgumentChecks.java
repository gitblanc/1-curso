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

	public static void isNotNull(Object obj) {
		isTrue(obj != null, "No puede ser null");
		
	}
	
	public static void isNotEmpty(String  inFileName) {
		isTrue(inFileName != null && !inFileName.isBlank());
		
	}
}
