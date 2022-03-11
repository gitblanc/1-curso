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
public class Photo extends Post {
	private String title;
	private String fileName;

	/**
	 * Constructor
	 * 
	 * @param title
	 * @param fileName
	 */
	public Photo(String user, String title, String fileName) {
		super(user);
		setTitle(title);
		setFileName(fileName);
	}

	/**
	 * @param title the title to set
	 */
	private void setTitle(String title) {
		ArgumentsCheck.isTrue(title != null, "Error: parámetro nulo");
		ArgumentsCheck.isTrue(title.length() > 0, "Error: cadena vacía");
		this.title = title;
	}

	/**
	 * @param fileName the fileName to set
	 */
	private void setFileName(String fileName) {
		ArgumentsCheck.isTrue(fileName != null, "Error: parámetro nulo");
		ArgumentsCheck.isTrue(fileName.length() > 0, "Error: cadena vacía");
		this.fileName = fileName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	public void print(PrintStream out) {
		out.println(toString());
	}

	public String toString() {
		return "Photo user: " + this.getUser() + "\t File: " + this.getFileName() + "\t Title: " + this.getTitle()
		+ "\t Likes: " + this.getLikes() + "\t Comments: " + this.getComment();
	}

	@Override
	public String toHtmlFormating() {
		return "<img src= " + this.getFileName() + ">" + this.getTitle() + "</img>";
	}
}
