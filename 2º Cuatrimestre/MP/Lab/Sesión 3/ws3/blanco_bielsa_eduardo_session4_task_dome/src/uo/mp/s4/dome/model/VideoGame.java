/**
 * 
 */
package uo.mp.s4.dome.model;

import java.io.PrintStream;

import uo.mp.checks.ArgumentsCheck;

/**
 * @author blanc
 *
 */
public class VideoGame extends Item {

	private Platform platform;
	private String author;
	private int numberOfPlayers;

	public VideoGame(String title, String author, int numberOfPlayers, Platform platform, double basePrice) {
		super(title, basePrice);
		setAuthor(author);
		setNumberOfPlayers(numberOfPlayers);
		ArgumentsCheck.isTrue(platform != null, "Error: platform nulo");
		this.platform = platform;
	}

	private void setAuthor(String author) {
		ArgumentsCheck.isTrue(author != null, "Error: author nulo");
		ArgumentsCheck.isTrue(author.length() > 0, "Error: author vacío");
		this.author = author;
	}

	private void setNumberOfPlayers(int numberOfPlayers) {
		ArgumentsCheck.isTrue(numberOfPlayers > 0, "Error: numberOfPlayers negativo");
		this.numberOfPlayers = numberOfPlayers;
	}

	public String getAuthor() {
		return author;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public String toString(PrintStream out) {

		String cadena = "";
		cadena += "VideoGame: " + getTitle() + "\n" + "Author: " + getAuthor() + "\n" + "Jugadores: "
				+ getNumberOfPlayers() + "\n" + "Plataforma: " + getPlatform().toString() + "\n";
		if (getOwn()) {
			cadena += "You own it" + "\n";
		} else {
			cadena += "You do not own it" + "\n";
		}
		cadena += "Comment: " + getComment();

		return cadena;
	}

	/**
	 * Si es VideoGame son iguales si lo son en título y plataforma
	 */
	@Override
	public boolean equals(Object item) {
		if (!(item instanceof VideoGame)) {
			return false;
		}
		if (this.getTitle().equals(((VideoGame) item).getTitle()) && this.getPlatform().equals(((VideoGame) item).getPlatform())) {
			return true;
		}
		return false;
	}

	@Override
	public double finalPrice() {
		return getBasePrice() + getBasePrice() * 0.1;
	}
}
