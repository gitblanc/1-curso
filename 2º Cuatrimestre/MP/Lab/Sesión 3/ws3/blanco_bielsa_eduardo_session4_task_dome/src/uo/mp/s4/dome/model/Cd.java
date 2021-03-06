package uo.mp.s4.dome.model;

import java.io.PrintStream;

import uo.mp.checks.ArgumentsCheck;

public class Cd extends Item implements Borrowable{

	private String artist;
	private int numberOfTracks;
	private int playingTime;
	private boolean isAvailable;

	public Cd(String theTitle, String theArtist, int tracks, int playingTime, double basePrice) {
		super(theTitle, basePrice);
		setArtist(theArtist);
		setPlayingTime(playingTime);
		setNumberOfTracks(tracks);
	}

	private void setArtist(String artist) {
		ArgumentsCheck.isTrue(artist != null, "Error: artista nulo");
		ArgumentsCheck.isTrue(artist.length() > 0, "Error: artist vac?o");
		this.artist = artist;

	}

	private void setNumberOfTracks(int numberOfTracks) {
		ArgumentsCheck.isTrue(numberOfTracks > 0, "Error: numberOfTracks negativo");
		this.numberOfTracks = numberOfTracks;

	}

	public String getArtist() {
		return this.artist;
	}

	public int getNumberOfTracks() {
		return this.numberOfTracks;
	}

	public String toString() {

		String cadena = "";
		cadena += "CD: " + getTitle() + " (" + getPlayingTime() + " mins)" + "\n" + "Artist: " + getArtist() + "\n"
				+ "Tracks: " + getNumberOfTracks() + "\n";
		if (getOwn()) {
			cadena += "You own it" + "\n";
		} else {
			cadena += "You do not own it" + "\n";
		}
		cadena += "Comment: " + getComment();

		return cadena;
	}

	private void setPlayingTime(int playingTime) {
		ArgumentsCheck.isTrue(playingTime > 0, "Error: playingTime negativo");
		this.playingTime = playingTime;

	}

	public int getPlayingTime() {
		return this.playingTime;
	}

	public void print2(PrintStream out) {
		out.println("Cd :  (" + getPlayingTime() + " mins)");
		out.println("Artist: " + getArtist());
		out.println("Tracks: " + getNumberOfTracks());
		super.print2(out);
	}

	/**
	 * Son iguales si el que recibe es un Cd con el mismo t?tulo y el mismo artista
	 */
	@Override
	public boolean equals(Object item) {
		if (!(item instanceof Cd)) {
			return false;
		}
		if (this.getTitle().equals(((Cd) item).getTitle()) && this.getArtist().equals(((Cd) item).getArtist())) {
			return true;
		}
		return false;
	}

	/**
	 * M?todo que devuelve el precio final del Cd m?s impuestos
	 */
	@Override
	public double finalPrice() {

		return (getBasePrice() + 2.0);
	}

	@Override
	public boolean isAvailable() {
		return this.getOwn() && this.isAvailable ;
	}


	@Override
	public void borrow() {
		this.isAvailable = false;
		
	}


	@Override
	public void giveBack() {
		this.isAvailable = true;
		
	}

}