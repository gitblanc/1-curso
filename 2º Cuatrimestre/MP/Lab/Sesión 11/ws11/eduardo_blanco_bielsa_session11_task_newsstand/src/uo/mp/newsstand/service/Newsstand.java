package uo.mp.newsstand.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.exception.AlreadyExistsException;
import uo.mp.newsstand.service.exception.InvalidFileNameException;
import uo.mp.newsstand.service.exception.NotExistsException;
import uo.mp.newsstand.service.parsers.PublicationParser;
import uo.mp.newsstand.service.serializers.OrderSerializer;
import uo.mp.newsstand.service.serializers.PublicationSerializer;
import uo.mp.util.file.FileUtil;
import uo.mp.util.file.ZipFileUtil;
import uo.mp.util.log.Logger;
import uo.mp2021.util.checks.ArgumentChecks;

public class Newsstand {

	private List<Publication> publications = new LinkedList<>();
	private List<Order> orders = new LinkedList<>();

	/**
	 * Loads all the products contained in the file desined by its name. None
	 * publication can be repeated regarding its name. If a publication is with a
	 * repeated name is already registered it will be ignored and a message sent to
	 * log.
	 * 
	 * @param inFileName, the name of the file
	 * @throws InvalidFileNameException 
	 * @throws NewsStandException, if the file name is invalid
	 */
	public void loadFile(String inFileName) throws InvalidFileNameException {
		ArgumentChecks.isTrue(inFileName !=  null);
		ArgumentChecks.isTrue(!inFileName.isBlank());
		checkFileNameLength(inFileName);
		List<String> lines;
		try {
			lines = new FileUtil().readLines(inFileName);
		} catch (FileNotFoundException e) {
			throw new InvalidFileNameException(inFileName);
		}
		List<Publication> fileProducts = new PublicationParser().parse(lines);
		addPublications(fileProducts);

	}

	private void checkFileNameLength(String inFileName) throws InvalidFileNameException {
		if(inFileName.length() < 5) {
			throw new InvalidFileNameException(inFileName);
		}
		
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
			} catch (AlreadyExistsException e) {
				Logger.log(e.getMessage());
			}
		}
	}

	/**
	 * Add the publication if it is name is not already registered
	 * 
	 * @param p, the product to be added
	 * @throws NewsStandException if the product's name is repeated
	 * @throws AlreadyExistsException 
	 */
	public void addPublication(Publication p) throws AlreadyExistsException {
		ArgumentChecks.isTrue(p != null);
		if(searchByName(p.getName()) == -1) {
			publications.add(p);
		}
		else {
			throw new AlreadyExistsException(p.getName());
		}
		

	}

	/**
	 * Removes the product whose indicated by its name
	 * 
	 * @param name of the publication to be removed
	 * @throws NotExistsException 
	 * @throws NewsStandExceptionif the product does not exist
	 */
	public void removePublication(String name) throws NotExistsException {
		ArgumentChecks.isTrue(name != null);
		int pos = searchByName(name);
		if(pos != -1) {
			publications.remove(pos);
		}
		else {
			throw new NotExistsException(name);
		}
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
	 * @return a list which a copy of the internal list of publications
	 */
	public List<Publication> getPublications() {
		return new ArrayList<>(publications);
	}

	/**
	 * Generates a list of orders. One for every product with stock under limits
	 */
	public List<Order> createOrders() {
		for(int i = 0; i < publications.size(); i++) {
			Publication p = publications.get(i);
			Order o = p.generateOrders();
			orders.add(o);
		}
		return orders;
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
	 * @throws FileNotFoundException 
	 * @throws NewsStandException in case - the file name is invalid
	 */
	public void saveOrdersToFile(String fileName) throws FileNotFoundException {
		ArgumentChecks.isTrue(fileName != null);
		OrderSerializer serializer = new OrderSerializer();
		List<String> lines = serializer.serialize(orders);
		new FileUtil().writeLines(fileName, lines);
	}

	/**
	 * Imports all the publications from the zip file and removes all the previous
	 * ones.
	 * 
	 * @param fileName
	 * @throws FileNotFoundException 
	 */
	public void importPublicationsFromZipFile(String fileName) throws FileNotFoundException {
		ArgumentChecks.isTrue(fileName != null);
		List<String> lines = new ZipFileUtil().readLines(fileName);
		List<Publication> file = new PublicationParser().parse(lines);
		addPublications(file);
	}

	/**
	 * Saves all the publications to a zip file. The file produced can be read by
	 * the method @see importPublicationsFromZipFile
	 * 
	 * @param fileName
	 * @throws FileNotFoundException 
	 */
	public void exportPublicationsToZipFile(String fileName) throws FileNotFoundException {
		ArgumentChecks.isTrue(fileName != null);
		PublicationSerializer serializer = new PublicationSerializer();
		List<String> lines = serializer.serialize(publications);
		new ZipFileUtil().writeLines(fileName, lines);
	}

	public void sortPublicationsByName() {
		Collections.sort(publications);
		
	}

}
