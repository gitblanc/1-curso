/**
 * 
 */
package uo.mp.lab12.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab12.questions.Choice;
import uo.mp.lab12.questions.Gap;
import uo.mp.lab12.questions.Question;
import uo.mp.lab12.questions.Value;
import uo.mp.newsstand.service.parsers.InvalidLineFormatException;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class QuestionParser {

	private int lineNumber = 0;
	
	public List<Question> parse(List<String> lines) {
		ArgumentChecks.isTrue(lines != null, "Error: lista nula");
		ArgumentChecks.isTrue(!lines.isEmpty(), "Error: lista vacía");
		List<Question> questionsList = new ArrayList<>();
		for(String line : lines) {
			this.lineNumber++;
			Question q;
			try {
				q = parseLine(line);
				questionsList.add(q);
			}catch (InvalidLineFormatException e) {
			}
		}
		return questionsList;
	}

	private Question parseLine(String line) throws InvalidLineFormatException {
		checkIsBlank(line);
		String[] parts = line.split("\t");//separador
		String type = parts[0];
		if(type.equals("choice")) {
			return parseChoice(parts);
		}else if(type.equals("gap")) {
			return parseGap(parts);
		}else if(type.equals("value")) {
			return parseValue(parts);
		}else {
			throw new InvalidLineFormatException(lineNumber,"Tipo desconocido");
		}
	}
	
	private Question parseValue(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 3);
		double weight = toDouble(parts[1]);
		double val = toDouble(parts[2]);
		return new Value(this.lineNumber,weight, val);
	}

	private Question parseGap(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 3);
		double weight = toDouble(parts[1]);
		String option = parts[2];
		return new Gap(this.lineNumber,weight, option);
	}

	private Question parseChoice(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 3);
		double weight = toDouble(parts[1]);
		String word = parts[2];
		return new Choice(this.lineNumber,weight, word);
	}

	private void checkNumberOfParts(String[] parts, int i) throws InvalidLineFormatException {
		if(parts.length != i) {
			throw new InvalidLineFormatException(lineNumber, "Número de partes incorrectas");
		}
		
	}

	private void checkIsBlank(String line) throws InvalidLineFormatException {
		if(line.isBlank()) { // es lo mismo que poner .trim().isEmpty()
			throw new InvalidLineFormatException(lineNumber, "línea en blanco");
		}
		
	}
	
	private double toDouble(String string) throws InvalidLineFormatException {
		try {
			return Double.parseDouble(string);
		}
		catch(NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, "Formato de número incorrecto");
		}
	}
}
