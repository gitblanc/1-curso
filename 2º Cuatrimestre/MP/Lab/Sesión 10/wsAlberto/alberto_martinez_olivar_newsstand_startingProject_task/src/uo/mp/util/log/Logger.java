package uo.mp.util.log;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uo.mp.util.file.ZipFileUtil;

/**
 * A very basic implementation of a logger utility.
 * For this the date are sent to the System.err standard output.
 * The format of every lines is: <timestamp> <message>
 */
public class Logger {

	private static PrintStream out = System.err;
	private static List<String> listError = new ArrayList<>();

	/**
	 * Sends the string received as message to the log prefixing it with 
	 * a timestamp 
	 * @param message
	 */
	public static void log(String message) {
		listAdd(new Date() + " " + message);
		out.print( new Date()  + " ");
		out.println( message );
	}

	private static void listAdd(String str) {
		listError.add(str);
		try {
			new ZipFileUtil().writeLines("Errores", listError);
		} catch (FileNotFoundException e) {
			log(e.getMessage());
		}
	}

	/**
	 * Sends the full stack trace of the exception received to the log
	 * prefixing it with a timestamp 
	 * @param t, the exception to be logged
	 */
	public static void log(Throwable t) {
		listAdd(new Date() + " " + t.getMessage());
		out.print( new Date()  + " ");
		t.printStackTrace( out );
	}
}
