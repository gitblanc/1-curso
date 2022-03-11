package uo.mp.s4.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.checks.ArgumentsCheck;
import uo.mp.s4.dome.model.Borrowable;
import uo.mp.s4.dome.model.Item;

public class MediaLibrary {

	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Borrowable> borrowableItems = new ArrayList<Borrowable>();

//	public MediaLibrary() {			YA NO ASIGNAR EN CONSTRUCTOR
//		this.items = new ArrayList<Item>();
//	}

	/**
	 * Añadir items a la lista (Cds o Dvds) No se permite añadir null
	 */
	public void add(Item item) {
		ArgumentsCheck.isTrue(item != null);
		if (!items.contains(item)) { // Comprueba que el objeto no está ya en la lista
			items.add(item);
			if (item instanceof Borrowable) {
				borrowableItems.add((Borrowable) item);
			}
		}

	}

	/**
	 * @return Devuelve el número de items que posee el propietario (getOwn a true)
	 */
	public int numberOfItemsOwned() {
		int cont = 0;
		for (Item item : items) {
			if (item.getOwn()) {
				cont++;
			}
		}
		return cont;
	}

	/**
	 * Imprime en el objeto out todos los datos de los items
	 */
	public void list(PrintStream out) {
		for (Item item : items) {
			item.print2(out);
		}
	}

	/**
	 * Devuelve una copia de la lista de ítems
	 */
	public ArrayList<Item> getItems() {
		ArrayList<Item> aux = new ArrayList<Item>(items);// así se hace una copia más rápido
		return aux;
	}

	/**
	 * Busca en lista item cuyos datos coinciden con los del item recibido por
	 * parámetro
	 */
	public int searchItem(Item item) {
		ArgumentsCheck.isTrue(item != null);
		for (Item it : items) {
			if (it.equals(item)) {
				return items.indexOf(item);
			}
		}
		return -1;
	}

	/**
	 * Busca un elemento en la lista cuyos datos son "iguales" a los del item
	 * recibido
	 * 
	 * Si es un CD son iguales si lo son en título y artista Si es un DVD son
	 * iguales si lo son en título y director Si es VideoGame son iguales si lo son
	 * en título y plataforma
	 *
	 * @param item a comparar
	 * @return posición del item encontrado o -1 si no se encuentra
	 */
	public int search(Item item) {
		ArgumentsCheck.isTrue(item != null, "Error: item nulo");
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(item)) {
				return i;
			}
		}
		return -1;
	}
	
	public Borrowable search(Borrowable item) {
		ArgumentsCheck.isTrue(item != null, "Error: item nulo");
		for (int i = 0; i < borrowableItems.size(); i++) {
			if (borrowableItems.get(i).equals(item)) {
				return borrowableItems.get(i);
			}
		}
		return null;
	}

	/**
	 * Imprime en el objeto out todos los responsables de los elementos que tienen
	 * propietario
	 */
	public void printResponsable(PrintStream out) {
		for (Item it : items) {
			out.print(it.getOwn());
		}
	}

	public void setAllOwned() {
		for (Item it : items) {
			it.setOwn(true);
		}
	}

	/**
	 * Otro modo de imprimir los datos de los items
	 * 
	 * @param out, de tipo PrintStream
	 */
	public void list2(PrintStream out) {
		ArgumentsCheck.isTrue(out != null);
		for (Item item : items) {
			item.print2(out);
			out.println();
		}
	}

	/**
	 * Método totalValue() que devuelve un valor de tipo value
	 */
	public double totalValue() {
		double cont = 0;
		for (Item item : items) {
			cont += item.finalPrice();
		}
		return cont;
	}

	/**
	 * Método generateCode() que devuelve una cadena con el código de todos los
	 * ítems de la base de datos separados por un guión.
	 */
	public String generateCode() {
		String cad = " ";
		for (Item item : items) {
			cad += item.getTitle().substring(0, 3) + items.indexOf(item) + "-";
		}
		return cad.substring(0, cad.length() - 1);
	}

	/**
	 * Método listBorrowableItems que permite listar los items que se pueden prestar
	 * @param out
	 */
	public void listBorrowableItems(PrintStream out) {
		for (Borrowable item : borrowableItems) {
			out.println(item);
			out.println();
		}
	}
	/**
	 * Método listAvailableBorrowableItems que permite listar los items que se pueden prestar
	 * y están disponibles para ello
	 * @param out
	 */
	public void listAvailableItems(PrintStream out) {
		for (Borrowable item : borrowableItems) {
			if (item.isAvailable()) {
				out.println(item);
			}
		}
	}
	
	
	public Borrowable borrow(Borrowable item) {
		Borrowable theItem = search(item);
		if(theItem == null) return null;	// no encontrado
		if(!theItem.isAvailable()) return null;	// no disponible
		
		theItem.borrow();
		return theItem;
	}
	
	public boolean giveBack(Borrowable item) {
		Borrowable theItem = search(item);
		if(theItem == null) return false;	// no encontrado
		if(!theItem.isAvailable()) return false;	// no disponible
		
		theItem.giveBack();
		return true;
	}
	
	
	}

