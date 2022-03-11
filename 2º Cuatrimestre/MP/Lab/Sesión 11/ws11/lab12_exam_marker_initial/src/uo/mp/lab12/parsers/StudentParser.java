/**
 * 
 */
package uo.mp.lab12.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab12.studentexams.StudentExam;
import uo.mp.newsstand.service.parsers.InvalidLineFormatException;
import uo.mp.util.log.Logger;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class StudentParser {
	private int lineNumber = 0;
	
	public StudentParser() {
		this.lineNumber = 0;
	}
	
	public List<StudentExam> parse(List<String> lines){
		ArgumentChecks.isTrue(lines != null, "Error: lista nula");
		ArgumentChecks.isTrue(!lines.isEmpty(), "Error: lista vacía");
		List<StudentExam> examsList = new ArrayList<>();
		for(String line:lines) {
			this.lineNumber++;
			StudentExam exam;
			try {
				exam = parseLine(line);
				examsList.add(exam);
			}catch (InvalidLineFormatException e) {
				Logger.log(e.getMessage());
			}
		}
		return examsList;
	}

	private StudentExam parseLine(String line) throws InvalidLineFormatException {
		checkIsBlank(line);
		String[] parts = line.split("\t");
		checkNumberOfParts(parts, 11);
		String identifier = parts[0];
		StudentExam exam = new StudentExam(identifier);
		for(int i = 1; i < parts.length; i++) {
			exam.addAnswer(parts[i]);
		}
		return exam;
		
	}

	private void checkNumberOfParts(String[] parts, int i) throws InvalidLineFormatException {
		if(parts.length != i) {
			throw new InvalidLineFormatException(lineNumber, "Número incorrecto de preguntas");
		}
		
	}

	private void checkIsBlank(String line) throws InvalidLineFormatException {
		if(line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber, "Falta identificador");
		}
		
	}
}
