package uo.mp.newsstand.ui;

import java.util.List;

import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.NewsStandException;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.ui.console.Console;
import uo.mp.util.log.Logger;

/**
 * It is in charge of interacting with the user: - Shows the menu of options -
 * Process the option chosen by the user - For that it asks the user the
 * necessary data to fulfill the request - Shows the result of the request - In
 * case of error shows an explaining message
 * 
 * Note: This is the unique class allowed to show information to the user
 */
public class UserInterface {
	private static final int EXIT = 0;

	private String type;

	private Menu menu = new Menu();
	private Newsstand newsStand = new Newsstand();

	public void show() {
		int option = EXIT;
		do {
			menu.show();
			option = menu.readOption();
			try {
				processOption(option);
			} catch (ApplicationException e) {
				Logger.log(e.getMessage());
			}
		} while (option != EXIT);
	}

	private void processOption(int option) throws ApplicationException {
		switch (option) {
		case EXIT:
			return;
		case 1:
			loadFile();
			break;
		case 2:
			showPublications();
			break;
		case 3:
			addPublication();
			break;
		case 4:
			removePublication();
			break;
		case 5:
			createOrders();
			break;
		case 6:
			saveOrdersToFile();
			break;
		case 7:
			importFromZip();
			break;
		case 8:
			exportToZip();
			break;
		}
	}

	private void loadFile() throws ApplicationException {
		String fileName = Console.readString("File name?");
		nameCheck(fileName);
		newsStand.loadFile(fileName);
	}

	/**
	 * Comprueba si el nombre del fichero tiene m?s de 5 caracteres y no es ni null
	 * ni un blanco.
	 * 
	 * @param fileName
	 * @throws ApplicationException 
	 */
	private void nameCheck(String fileName) throws ApplicationException {
		if (fileName.length() < 5 || fileName == null || fileName == " ") {
			throw new ApplicationException(type,
					"El nombre del fichero es menor de 5 caracteres, es null o un blanco.");
		}

	}

	private void addPublication() throws ApplicationException {
		Publication p = new PublicationForm().askForPublication();
		try {
			newsStand.addPublication(p);
		} catch (NewsStandException e) {
			Logger.log(e.getMessage());
		}
	}

	private void removePublication() {
		String name = Console.readString("publication name?");
		newsStand.removePublication(name);
	}

	private void showPublications() {
		List<Publication> publications = newsStand.getPublications();
		listPublications(publications);
	}

	private void createOrders() {
		newsStand.createOrders();
	}

	private void listPublications(List<Publication> publications) {
		Console.println("\nList of publications");
		Console.println("------------------");
		for (Publication p : publications) {
			System.out.println(p);
		}

		Console.println("------------------");
	}

	private void saveOrdersToFile() {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile(fileName);
	}

	private void importFromZip() {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile(fileName);
	}

	private void exportToZip() {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile(fileName);
	}

}
