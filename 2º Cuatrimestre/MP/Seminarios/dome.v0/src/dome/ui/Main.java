package dome.ui;

import dome.entities.Cd;
import dome.entities.Dvd;
import dome.entities.MediaLibrary;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		MediaLibrary db = new MediaLibrary();

		Dvd dvd = new Dvd("The Godfather", "Koppola", 340);
		Cd cd = new Cd("Nevermind", "Nirvana", 10, 55);

		db.add(cd);
		db.add(dvd);

		System.out.println("LISTADO de los objetos creados ");
		System.out.println("---------------------------------\n");

		cd.print(System.out);
		dvd.print(System.out);

		System.out.println("LISTADO de los objetos almacenados  ");
		System.out.println("-----------------------------------n");
		db.list(System.out);
	}

}
