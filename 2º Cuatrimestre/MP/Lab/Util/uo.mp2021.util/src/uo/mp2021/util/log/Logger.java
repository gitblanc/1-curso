/**
 * 
 */
package uo.mp2021.util.log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

/**
 * @author blanc
 *
 */
public class Logger {

	private static final String FILE = "Log.txt";
	   private static final boolean APPEND = true;

	   private static PrintStream out = System.err;

	   /**
	    * Sends the string received as message to the log prefixing it with 
	    * a timestamp 
	    * @param message Mensaje
	    */
	   public static void log(String message) {
	       try {
	           out = new PrintStream(new FileOutputStream(FILE, APPEND));

	           try {
	               out.print(new Date() + " ");
	               out.println(message);
	           } finally {
	               out.close();
	           }
	       }catch(IOException e) {
	           out = System.err;
	           out.println("No se ha podido guardar el log en el fichero\n");
	           out.print(new Date() + " ");
	           out.println(message);
	       }
	   }

	   /**
	    * Sends the full stack trace of the exception received to the log
	    * prefixing it with a timestamp 
	    * @param t, the exception to be logged
	    */
	   public static void log(Throwable t) {
	       try {
	           out = new PrintStream(new FileOutputStream(FILE, APPEND));

	           try {
	               out.print(new Date() + " ");
	               t.printStackTrace( out );
	           } finally {
	               out.close();
	           }
	       }catch(IOException e) {
	           out = System.err;
	           out.println("No se ha podido guardar el log en el fichero\n");
	           out.print(new Date() + " ");
	           t.printStackTrace( out );
	       }
	   }

}
