package uo.mp.newsstand.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uo.mp.exception.NotYetImplementedException;
import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.parsers.PublicationParser;
import uo.mp.newsstand.service.serializers.OrderSerializer;
import uo.mp.newsstand.service.serializers.PublicationSerializer;
import uo.mp.util.file.FileUtil;
import uo.mp.util.file.ZipFileUtil;
import uo.mp.util.log.Logger;

public class Newsstand {

	private String publicationName;

	private List<Publication> publications = new LinkedList<>();
	private List<Order> orders = new LinkedList<>();

	/**
	 * Loads all the products contained in the file desined by its name. None
	 * publication can be repeated regarding its name. If a publication is with a
	 * repeated name is already registered it will be ignored and a message sent to
	 * log.
	 * 
	 * @param inFileName, the name of the file
	 * @throws NewsStandException, if the file name is invalid
	 */
	public void loadFile(String inFileName) {
		List<String> lines = new FileUtil().readLines(inFileName);
		List<Publication> fileProducts = new PublicationParser().parse(lines);
		addPublications(fileProducts);
	}

	/**
	 * Add all the publications contained on the list passed as argument. None
	 * publication can be repeated regarding its name. If a publication is with a
	 * repeated name is already registered it will be ignored and a message sent to
	 * log.
	 * 
	 * @param newProducts, the list with the new publications
	 * @throws NewsStandException
	 */
	private void addPublications(List<Publication> newProducts) {

		for (Publication p : newProducts) {
			try {
				addPublication(p);
			} catch (NewsStandException e) {
				Logger.log(e.getMessage());
			}

		}
	}

	/**
	 * Add the publication if it is name is not already registered
	 * 
	 * @param p, the product to be added
	 * @throws NewsStandException if the product's name is repeated
	 */
	public void addPublication(Publication p) throws NewsStandException {
		seekPublications(p);
		publications.add(p);
	}

	/**
	 * Antes de añadir una nueva publicación, comprobamos que no existe en la lista.
	 * En caso contario, lanzamos una excepción.
	 * 
	 * @param newProducts
	 * @throws NewsStandException
	 */
	private void seekPublications(Publication p) throws NewsStandException {
		for (int i = 0; i < publications.size(); i++) {
			if (publications.get(i).getName() == p.getName()) {
				throw new NewsStandException(publicationName, "La publicación ya está incluida en la lista");
			}
		}

	}

	/**
	 * Removes the product whose indicated by its name
	 * 
	 * @param name of the publication to be removed
	 * @throws NewsStandExceptionif the product does not exist
	 */
	public void removePublication(String name) {
		int pos = searchByName(name);
		publications.remove(pos);
	}

	private int searchByName(String name) {
		for (int i = 0; i < publications.size(); i++) {
			Publication p = publications.get(i);
			if ((p.getName().equals(name)) /* compare both names */ )
				return i;
		}
		return -1;
	}

	/**
	 * Siempre se devuelve una copia de la lista para no modificar la orginal. Se
	 * mantiene encapsulada.
	 * 
	 * @return a list which a copy of the internal list of publications
	 */
	public List<Publication> getPublications() {
		return new ArrayList<>(publications); // copiamos la lista
	}

	/**
	 * Generates a list of orders. One for every product with stock under limits
	 */
	public void createOrders() {
		for (Order o : orders) {
			orders.add(o);
		}
	}

	/**
	 * @return a list which a copy of the internal list of orders
	 */
	public List<Order> getOrders() {
		// Returns a list, copy of our own list to not break the encapsulation
		// A copy constructor needed in our lists
		return new ArrayList<>(orders);
	}

	/**
	 * Save all orders to a file with the given format
	 * 
	 * @param fileName
	 * @throws NewsStandException in case - the file name is invalid
	 */
	public void saveOrdersToFile(String fileName) {
		OrderSerializer serializer = new OrderSerializer();
		List<String> lines = serializer.serialize(orders);
		new FileUtil().writeLines(fileName, lines);
	}

	/**
	 * Imports all the publications from the zip file and removes all the previous
	 * ones.
	 * 
	 * @param fileName
	 */
	public void importPublicationsFromZipFile(String fileName) {
		throw new NotYetImplementedException();
	}

	/**
	 * Saves all the publications to a zip file. The file produced can be read by
	 * the method @see importPublicationsFromZipFile
	 * 
	 * @param fileName
	 */
	public void exportPublicationsToZipFile(String fileName) {
		PublicationSerializer serializer = new PublicationSerializer();
		List<String> lines = serializer.serialize(publications);
		new ZipFileUtil().writeLines(fileName, lines);
	}

}
