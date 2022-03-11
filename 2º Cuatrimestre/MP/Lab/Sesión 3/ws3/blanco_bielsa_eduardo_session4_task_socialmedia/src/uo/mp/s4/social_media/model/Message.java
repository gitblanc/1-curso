/**
 * 
 */
package uo.mp.s4.social_media.model;

import java.io.PrintStream;

import uo.mp.checks.ArgumentsCheck;

/**
 * @author blanc
 *
 */
public class Message extends Post {
	private String message;

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public Message(String user, String message) {
		super(user);
		setMessage(message);
	}

	private void setMessage(String message) {
		ArgumentsCheck.isTrue(message != null, "Error: parámetro nulo");
		ArgumentsCheck.isTrue(message.length() > 0, "Error: cadena vacía");
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void print(PrintStream out) {
		out.println(toString());
	}
	
	public String toString() {
		return "Message user: " + this.getUser() + "\t msg: " + this.getMessage() + "\t Likes: " + this.getLikes()
		+ "\t Comments: " + this.getComment();
	}

	@Override
	public String toHtmlFormating() {
		return "<p>" + this.getMessage() + "</p>"; 
		
	}

}
