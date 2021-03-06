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

	/**
	 * @return The new Publication object created. It will be be of any 
	 * of the child types of Publication.
	 */
	public Publication askForPublication() {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
			case "n": return askForNewsPaper();
			case "m": return askForMagazine();
			default:  return null;
		}

	}

	private Publication askForMagazine() {
		String name = Console.readString("name?");
		
		int stock = -1;
		while (stock < 0) 
			stock = Console.readInteger("stock?");
		
		int sales = -1;
		while (sales < 0) 
			sales = Console.readInteger("sales?");
		
		int regularity = -1;
		while (regularity < 0) 
			regularity = Console.readInteger("regularity?");
		

		return new Magazine(name, stock, sales, regularity);
	}

	private Publication askForNewsPaper() {
		String name = Console.readString("name?");
		
		int stock = -1;
		while (stock < 0) 
			stock = Console.readInteger("stock?");
		
		int sales = -1;
		while (sales < 0) 
			sales = Console.readInteger("sales?");

		return new Newspaper(name, stock, sales);
	}

}
