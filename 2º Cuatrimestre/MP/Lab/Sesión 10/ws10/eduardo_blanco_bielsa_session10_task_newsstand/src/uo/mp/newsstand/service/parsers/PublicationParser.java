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
		ArgumentChecks.isTrue(lines != null, "Error: lista nula");
		ArgumentChecks.isTrue(!lines.isEmpty(), "Error: lista vac?a");
		List<Publication> publicationList = new ArrayList<>();
		for(String line: lines) {
			this.lineNumber++;
			Publication p;
			try {						// SI no hago el try catch, salta un error
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
		String[] parts = line.split("\t");//el \t es el separador
		String type = parts[0];
		if (type.equals("newspaper")) {
			return parseNewsPaper(parts);
		}
		else if(type.equals("magazine")){
			return parseMagazine(parts);
		}
		else {
			throw new InvalidLineFormatException(lineNumber, "Tipo desconocido"); 
		}
	}

	private void checkIsBlank(String line) throws InvalidLineFormatException {
		if(line.isBlank()) { // es lo mismo que poner .trim().isEmpty()
			throw new InvalidLineFormatException(lineNumber, "l?nea en blanco");
		}
		
	}

	private Publication parseMagazine(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 5);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		int frequency = toInteger(parts[4]);
		return new Magazine(name, stock, sales, frequency);
	}

	private void checkNumberOfParts(String[] parts, int i) throws InvalidLineFormatException {
		if(parts.length != i) {
			throw new InvalidLineFormatException(lineNumber, "N?mero incorrecto de partes en la l?nea");
		}
		
	}

	private Publication parseNewsPaper(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 4);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		return new Newspaper(name, stock, sales);
	}

	private int toInteger(String string) throws InvalidLineFormatException {
		try {
			return Integer.parseInt(string);
		}
		catch(NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, "Formato de n?mero incorrecto");
		}
	}

}
