package uo.mp.newsstand.ui;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.exception.NewsStandException;
import uo.mp.newsstand.ui.console.Console;

/**
 * Asks the user all the data for a new publication.
 * 
 */
public class PublicationForm {

	/**
	 * @return The new Publication object created. It will be be of any 
	 * of the child types of Publication.
	 * @throws NewsStandException 
	 */
	public Publication askForPublication() throws NewsStandException {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
			case "n": return askForNewsPaper();
			case "m": return askForMagazine();
			default:   throw new NewsStandException("Tipo de publicacion desconocida");
		}

	}

	private Publication askForMagazine() {
		String name = checkName();
		int stock = checkStock();
		int sales = Console.readInteger("sales?");
		int regularity = Console.readInteger("regularity?");

		return new Magazine(name, stock, sales, regularity);
	}

	/**
	 * checkear q el nombre no sea nulo
	 * @return
	 */
	private String checkName() {
		String name = null;
		do {
			name = Console.readString("name?");
		} while (name.equals(null) || name.equals(""));
		return name;
	}

	/**
	 * checkeamos q el stock se encuentre entre 100 y 0
	 * 
	 * @return stock
	 */
	private int checkStock() {
		int stock = -1;
		
		do {
			stock = Console.readInteger("stock?");
		} while(stock>100 || stock<0);
		return stock;
	}
	
	private Publication askForNewsPaper() {
		String name = checkName();
		int stock = checkStock();
		int sales = Console.readInteger("sales?");

		return new Newspaper(name, stock, sales);
	}

}
