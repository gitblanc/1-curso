package uo.mp.newsstand.ui;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.exception.NewsstandException;
import uo.mp.newsstand.ui.console.Console;

/**
 * Asks the user all the data for a new publication.
 * 
 */
public class PublicationForm {

	/**
	 * @return The new Publication object created. It will be be of any 
	 * of the child types of Publication.
	 * @throws NewsstandException 
	 */
	public Publication askForPublication() throws NewsstandException {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
			case "n": return askForNewsPaper();
			case "m": return askForMagazine();
			default:  throw new NewsstandException("Tipo de publicacion desconocido");
		}

	}

	private Publication askForMagazine() {
		String name = Console.readString("name?");
		int stock = Console.readInteger("stock?");
		int sales = Console.readInteger("sales?");
		int regularity = Console.readInteger("regularity?");

		return new Magazine(name, stock, sales, regularity);
	}

	private Publication askForNewsPaper() {
		String name = Console.readString("name?");
		int stock = Console.readInteger("stock?");
		int sales = Console.readInteger("sales?");

		return new Newspaper(name, stock, sales);
	}

}
