package uo.mp.newsstand.ui;

import java.io.FileNotFoundException;
import java.util.List;

import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.InvalidFileNameException;
import uo.mp.newsstand.service.exception.NewsStandException;
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

	private Menu menu = new Menu();
	private Newsstand newsStand = new Newsstand();

	public void show() {
		int option = EXIT;
		do {
			menu.show();
			option = menu.readOption();
			try {
				processOption(option);
			} catch (RuntimeException e) {
				handleSystemError(e);
				return;// para salir de un bucle poner return
			} catch (Exception e) {
				handleUserError(e);
			}
		} while (option != EXIT);
	}

	private void handleSystemError(RuntimeException e) {
		String str = "Error del sistema. \n" + "Por favor, p?ngase en contacto" + " con el servicio t?cnico";
		Console.println(str);
		Logger.log(e);
	}

	private void handleUserError(Exception e) {
		String str = "Ha habido un error \n" + e.getMessage() + ".Por favor, int?ntelo de nuevo";
		Console.println(str);
	}

	private void processOption(int option) throws NewsStandException, ApplicationException, FileNotFoundException {
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
			break; // hasta aqui
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

	private void loadFile() throws InvalidFileNameException {
		String fileName = Console.readString("File name?");
		newsStand.loadFile(fileName);
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
		try {
			newsStand.removePublication(name);
		} catch (NewsStandException e) {
			Logger.log(e.getMessage());
		}
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

	private void saveOrdersToFile() throws FileNotFoundException {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile(fileName);
	}

	private void importFromZip() throws FileNotFoundException {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile(fileName);
	}

	private void exportToZip() throws FileNotFoundException {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile(fileName);
	}

}
