package dome.entities;



import java.io.PrintStream;

public class Cd extends Item {

	private String artist;
	private int numberOfTracks;
	public Cd(String theTitle, String theArtist, int tracks, int time) {
		setTitle(theTitle);
		setArtist(theArtist);
		setNumberOfTracks(tracks);
		setPlayingTime(time);
		setOwn(false);
		setComment("No comment");
	}

	public void setArtist(String artist) {
		if (artist != null) {
			this.artist = artist;
		}
	}

	public void setNumberOfTracks(int numberOfTracks) {
		if (numberOfTracks > 0) {
			this.numberOfTracks = numberOfTracks;
		}
	}

	public String getArtist() {
		return this.artist;
	}
	
	public int getNumberOfTracks() {
		return this.numberOfTracks;
	}
	
	public void print(PrintStream out) {
		out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
		out.println("Artist: " + getArtist());
		out.println("Tracks: " + getNumberOfTracks());
		if (getOwn()) {
			out.println("You own it");
		} else {
			out.println("You do not own it");
		}
		out.println("Comment: " + getComment());
	}
}