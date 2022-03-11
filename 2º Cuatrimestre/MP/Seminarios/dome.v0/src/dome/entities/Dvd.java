package dome.entities;



import java.io.PrintStream;

public class Dvd extends Item {
	private String director;
	

	public Dvd(String theTitle, String theDirector, int time) {
		setTitle(theTitle);
		setDirector(theDirector);
		setPlayingTime(time);
		setOwn(false);
		setComment("No comment");
	}

	public void setDirector(String director) {
		if (director != null) {
			this.director = director;
		}
	}

	public String getDirector() {
		return this.director;
	}
	
	public void print(PrintStream out) {
		out.println("DVD: " + getTitle() + " (" + getPlayingTime() + " mins)");
		out.println("Director: " + getDirector());
		if (getOwn()) {
			out.println("You own it");
		} else {
			out.println("You do not own it");
		}
		out.println("Comment: " + getComment());
	}

}
