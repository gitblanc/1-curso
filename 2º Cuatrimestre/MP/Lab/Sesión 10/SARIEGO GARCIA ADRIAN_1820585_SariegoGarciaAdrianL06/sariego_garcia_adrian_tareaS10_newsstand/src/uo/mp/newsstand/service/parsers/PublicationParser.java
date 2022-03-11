package uo.mp.newsstand.service.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.util.log.Logger;
import uo.mp2021.util.checks.ArgumentChecks;

public class PublicationParser {

	private int lineNumber = 0;

	public List<Publication> parse(List<String> lines) {
		ArgumentChecks.isNotNull(lines);
		List<Publication> publicationList = new ArrayList<>();
		for(String line:lines) {
			lineNumber ++;
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

	private Publication parseLine(String line) throws InvalidLineFormatException {
		checkIsBlank(line);
		String[] parts = line.split("\t");
		String type = parts[0];
		if(type.equals("newspaper")) {
			return parseNewspaper(parts);
		} else if(type.equals("magazine")) {
			return parseMagazine(parts);
		} else { 
			throw new InvalidLineFormatException(lineNumber, "Tipo " + type +  " desconocido");
		}
	}

	private Publication parseNewspaper(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 4);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		
		return new Newspaper(name, stock, sales);
	}
	

	private Publication parseMagazine(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 5);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		int frequency = toInteger(parts[4]);
		
		return new Magazine(name, stock, sales, frequency);
	}
	

	private int toInteger(String string) throws InvalidLineFormatException {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, "Formato de numero incorrecto");
		}	
	}
	
	private void checkIsBlank(String line) throws InvalidLineFormatException {
		if(line.isBlank()){ //Quita espacios en blanco y despues comprueba
			throw new InvalidLineFormatException(lineNumber ,"linea en blanco");		
		}	
	}
	
	private void checkNumberOfParts(String[] parts, int validParts) throws InvalidLineFormatException {
		if(parts.length != validParts) {
			throw new InvalidLineFormatException(lineNumber, "numero incorrecto de partes");
		}
		
	}

}
