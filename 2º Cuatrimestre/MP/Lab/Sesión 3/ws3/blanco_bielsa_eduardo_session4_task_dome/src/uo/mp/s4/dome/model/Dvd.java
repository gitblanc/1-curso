package uo.mp.s4.dome.model;

import uo.mp.checks.ArgumentsCheck;

public class Dvd extends Item {
	private String director;
	private int playingTime;

	public Dvd(String theTitle, String theDirector, int playingTime, double basePrice) {
		super(theTitle, basePrice);
		setDirector(theDirector);
		setPlayingTime(playingTime);
	}

	private void setDirector(String director) {
		ArgumentsCheck.isTrue(director != null, "Error: director nulo");
		ArgumentsCheck.isTrue(director.length() > 0, "Error: director vacío");
		this.director = director;

	}

	public String getDirector() {
		return this.director;
	}

	public String toString() {

		String cadena = "";
		cadena += "DVD: " + getTitle() + " (" + getPlayingTime() + " mins)" + "\n" + "Director: " + getDirector()
				+ "\n";
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

	/**
	 * Si es un DVD son iguales si lo son en título y director
	 */
	@Override
	public boolean equals(Object item) {
		if (!(item instanceof Dvd)) {
			return false;
		}
		if (this.getTitle().equals(((Dvd) item).getTitle()) && this.getDirector().equals(((Dvd) item).getDirector())) {
			return true;
		}
		return false;
	}

	@Override
	public double finalPrice() {

		return getBasePrice();
	}
}
