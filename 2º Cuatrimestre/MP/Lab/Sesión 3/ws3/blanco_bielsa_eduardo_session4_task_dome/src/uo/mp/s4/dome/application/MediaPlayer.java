/**
 * 
 */
package uo.mp.s4.dome.application;

import uo.mp.s4.dome.model.Book;
import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.service.MediaLibrary;

/**
 * @author blanc
 *
 */
public class MediaPlayer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		run();

	}
	
	public static void run() {
		MediaLibrary m = new MediaLibrary();
		
		Book b1 = new Book("Lord of the Rings",20.0, "Tolkien", "World", "976-173538");
		Book b2 = new Book("WonderWall",20.0, "J.Cole", "ADD", "976-2131");
		Book b3 = new Book("Mundo patata",20.0, "Guillermo", "SD", "976-11273538");
		Book b4 = new Book("Hormigueo",20.0, "Martha", "F", "976-12415135");
		Book b5 = new Book("Star Wars",20.0, "G.Lucas", "V", "976-1712313538");
		Cd c1 = new Cd("Tornado of Souls","Megadeth",12, 45, 20.0);
		Cd c2 = new Cd("Drag the Waters","Megadeth",12, 45, 20.0);
		Cd c3 = new Cd("Nimbus","Megadeth",12, 45, 20.0);
		
		Dvd dv1 = new Dvd("Tornado of Souls","Megadeth",12, 20.0);
		Dvd dv2 = new Dvd("Tornado of Souls","Megadeth",12, 20.0);
		
		VideoGame v1 = new VideoGame("GTA5","Rockstar",2, Platform.PLAYSTATION, 20.0);
		VideoGame v2 = new VideoGame("Monkey","J.Cole",4, Platform.PLAYSTATION, 20.0);
		
		b1.giveBack();
		b2.giveBack();
		b3.giveBack();
		b4.giveBack();
		b5.giveBack();
		
		c1.giveBack();
		c2.giveBack();
		c3.giveBack();
		
		m.add(c1);
		m.add(dv1);
		m.add(v1);
		m.add(c2);
		m.add(dv2);
		m.add(v2);
		m.add(b1);
		m.add(b2);
		m.setAllOwned();
		
		m.add(c3);
		m.add(b3);
		m.add(b4);
		m.add(b5);
		

		b3.borrow();
		c3.borrow();
		
		
		
		System.out.println(m.numberOfItemsOwned());
		m.printResponsable(System.out);
		m.list(System.out);
		System.out.println("-------Listado de list2--------");
		System.out.println();
		m.list2(System.out);
		System.out.println("---------C?digo generado por los Items:");
		System.out.println(m.generateCode());
		System.out.println("---------Items que se pueden prestar:");
		m.listBorrowableItems(System.out);
		System.out.println("---------Items disponibles para prestar prestar:");
		m.listAvailableItems(System.out);
		
		
		
	}

}
