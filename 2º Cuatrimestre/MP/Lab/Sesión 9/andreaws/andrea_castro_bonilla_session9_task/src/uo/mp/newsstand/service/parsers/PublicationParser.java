package uo.mp.newsstand.service.parsers;

import java.util.ArrayList;
import java.util.List;
import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.util.log.Logger;

public class PublicationParser {

	private int lineNumber = 0;

	public List<Publication> parse(List<String> lines) {
		List<Publication> publicationList = new ArrayList<>();
		for (String line : lines) {
			lineNumber++;
			try {

				Publication p = parseLine(line);
				publicationList.add(p);

			} catch (InvalidLineFormatException e) {
				Logger.log(e.getMessage());
			}
//			catch (NumberFormatException e) {
//				Logger.log(e.getMessage());
//			}
		}
		return publicationList;
	}

	private Publication parseLine(String line) throws InvalidLineFormatException {
		checkIsBlank(line); // Línea en blanco
		String[] parts = line.split("\t");
		String type = parts[0];
		if (type.equals("newspaper")) {
			return parseNewsPaper(parts);
		} else if (type.endsWith("magazine")) {
			return ParseMagazine(parts);
		} else {
			throw new InvalidLineFormatException(lineNumber, "Tipo desconocido");
		}
	}

	private void checkIsBlank(String line) throws InvalidLineFormatException {
		if (line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber, "Línea en blanco");
		}
	}

	private Publication ParseMagazine(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sold = toInteger(parts[3]);
		int frequency = toInteger(parts[4]);
		return new Magazine(name, stock, sold, frequency);
	}

	private void checkNumberOfParts(String[] parts) throws InvalidLineFormatException {
		if (parts.length != 5) {
			throw new InvalidLineFormatException(lineNumber, "Número incorrecto de partes");
		}

	}

	private Publication parseNewsPaper(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sold = toInteger(parts[3]);
		return new Newspaper(name, stock, sold);
	}

	/**
	 * Convierte un String en un entero
	 * 
	 * @param string
	 * @return
	 * @throws InvalidLineFormatException
	 */
	private int toInteger(String string) throws InvalidLineFormatException {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, "Formato de número incorrecto");
		}
	}

	public int getLineNumber() {
		return lineNumber;
	}

}
