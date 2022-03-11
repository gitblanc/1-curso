package uo.mp.newsstand.ui;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.ui.console.Console;

/**
 * Asks the user all the data for a new publication.
 * 
 */
public class PublicationForm {

	@SuppressWarnings("unused")
	private String type;

	/**
	 * @return The new Publication object created. It will be be of any of the child
	 *         types of Publication.
	 * @throws ApplicationException
	 */
	public Publication askForPublication() throws ApplicationException {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();

		if (!type.equals("n") && !type.equals("m")) {
			throw new ApplicationException(type, "Tipo de publicación no reconocido");
		}

		switch (type) {
		case "n":
			return askForNewsPaper();
		case "m":
			return askForMagazine();
		default:
			return null;

		}

	}

	private Publication askForMagazine() {
		String name = Console.readString("name?");
		while (name == " ") {
			@SuppressWarnings("unused")
			String name2 = Console.readString("name?");
		}

		int stock = Console.readInteger("stock?");
		while (!(stock >= 0 && stock <= 100)) {
			@SuppressWarnings("unused")
			int stock2 = Console.readInteger("stock?");
		}

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
