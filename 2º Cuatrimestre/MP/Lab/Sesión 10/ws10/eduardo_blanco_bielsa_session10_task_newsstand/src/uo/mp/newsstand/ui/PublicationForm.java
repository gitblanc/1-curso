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
	 * @throws ApplicationException 
	 */
	public Publication askForPublication() throws ApplicationException {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
			case "n": return askForNewsPaper();
			case "m": return askForMagazine();
			default:  throw new ApplicationException("Tipo incorrecto");
		}

	}

	private Publication askForMagazine() throws ApplicationException {
		String name = Console.readString("name?");// cadena
		if (name.isBlank()) {
			tryAgainName(name);
			throw new ApplicationException("Cadena vac?a");
		}

		int stock = Console.readInteger("stock?");// stock
		if (!isValidStock(stock)) {
			tryAgainStock(stock);
			throw new ApplicationException("Stock inv?lido");
		}

		int sales = Console.readInteger("sales?");
		int regularity = Console.readInteger("regularity?");

		return new Magazine(name, stock, sales, regularity);
	}

	private Publication askForNewsPaper() throws ApplicationException {
		String name = Console.readString("name?");
		if (name.isBlank()) {// cadena
			tryAgainName(name);
			throw new ApplicationException("Cadena vac?a");
		}

		int stock = Console.readInteger("stock?");// stock
		if (!isValidStock(stock)) {
			tryAgainStock(stock);
			throw new ApplicationException("Stock inv?lido");
		}

		int sales = Console.readInteger("sales?");

		return new Newspaper(name, stock, sales);
	}

	/**
	 * M?todo que pide otro nombre en caso de que sea vac?o
	 * 
	 * @param name
	 * @return
	 */
	private String tryAgainName(String name) {
		do {
			name = Console.readString("name?");
		} while (name.isBlank());
		return name;
	}

	/**
	 * M?todo que pide otro stock hasta que cumpla las condiciones
	 * 
	 * @param stock
	 * @return
	 */
	private int tryAgainStock(int stock) {
		do {
			stock = Console.readInteger("stock?");
		} while (!isValidStock(stock));
		return stock;
	}

	/**
	 * M?todo que comprueba que el stock es v?lido
	 * 
	 * @param stock
	 * @return
	 */
	private boolean isValidStock(int stock) {
		return stock >= 0 && stock <= 100;
	}


}