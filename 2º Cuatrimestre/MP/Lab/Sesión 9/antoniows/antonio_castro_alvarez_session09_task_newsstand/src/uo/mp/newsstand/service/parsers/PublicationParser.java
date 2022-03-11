package uo.mp.newsstand.service.parsers;


import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
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
			Publication p;
			try {
				p = parseLine(line);
				publicationList.add(p);		
			} catch (InvalidLineFormatException e) {
				Logger.log(e.getMessage());
			}
				
		}
		return publicationList;
	}

	
	private Publication parseLine(String line)throws InvalidLineFormatException{
		checkIsBlank(line);
		String[] parts = line.split("\t");
		String type = parts[0];
		if (type.equals("newspaper")){
			return parseNewsPaper(parts);
		}
		else if (type.equals("magazine")) {
			return parseMagazine(parts);
		} else {
			throw new InvalidLineFormatException(lineNumber, "Tipo desconocido");
		}
		
	}
	
	

	
	private Publication parseNewsPaper(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 4);
		String name = parts [1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		return new Newspaper(name, stock, sales);
	}

	
	private Publication parseMagazine(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 5);
		String name = parts [1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		int frequency = toInteger(parts[4]);
		return new Magazine(name, stock, sales, frequency);
	}
	
	

	private int toInteger(String str) throws InvalidLineFormatException {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, "Formato de número incorrecto");
		}
	}
	
	
	private void checkIsBlank(String line) throws InvalidLineFormatException {
		if (line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber, "línea en blanco");
		}
	}
	
	
	private void checkNumberOfParts(String[] parts, int expected) throws InvalidLineFormatException {
		if (parts.length != expected) {
			throw new InvalidLineFormatException(lineNumber, 
												 "número incorrecto de partes");
		}
	}

}
