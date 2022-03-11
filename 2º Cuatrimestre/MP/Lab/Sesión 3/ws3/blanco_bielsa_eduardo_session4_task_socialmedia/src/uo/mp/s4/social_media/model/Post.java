/**
 * 
 */
package uo.mp.s4.social_media.model;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.checks.ArgumentsCheck;

/**
 * @author blanc
 *
 */
public abstract class Post {
	private int likes;
	private ArrayList<String> comment = new ArrayList<String>();
	private String user;

	/**
	 * @param likes
	 * @param comment
	 * @param user
	 */
	public Post(String user) {
		setUser(user);
		setLikes(0);

	}

	/**
	 * @param likes the likes to set
	 */
	protected void setLikes(int likes) {
		ArgumentsCheck.isTrue(likes >= 0, "Error: parámetro inválido");
		this.likes = likes;
	}

	/**
	 * @param user the user to set
	 */
	protected void setUser(String user) {
		ArgumentsCheck.isTrue(user != null, "Error: parámetro nulo");
		ArgumentsCheck.isTrue(user.length() > 0, "Error: cadena vacía");
		this.user = user;
	}

	/**
	 * @param comment the comment to set
	 */
	protected void setComment(ArrayList<String> comment) {
		ArgumentsCheck.isTrue(comment != null, "Error: parámetro nulo");
		this.comment = comment;
		
	}

	/**
	 * @return the likes
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * @return the comment
	 */
	public ArrayList<String> getComment() {
		return comment;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	public abstract void print(PrintStream out);

	public abstract String toHtmlFormating();

}
