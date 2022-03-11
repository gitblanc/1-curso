/**
 * 
 */
package uo.mp.battleship.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uo.mp.battleship.ranking.Score;
import uo.mp.battleship.session.GameLevel;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class ScoreParser {

	private int lineNumber = 0;

	/**
	 * Método que lee cada línea, extra el objeto Score y lo añade a una lista de
	 * Score. Puede o no lanzar excepciones.
	 * @param lines
	 * @return scores
	 */
	public List<Score> parse(List<String> lines){
		ArgumentChecks.isTrue(lines != null);
		List<Score> scores = new ArrayList<>();
		
		for(String line : lines) {
			lineNumber++;
			Score score;
			try {
				score = parseLine(line);
				scores.add(score);
			}
			catch(ParseException e) {
				System.out.println("Error en el parser");
			}
			catch(InvalidLineFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		return scores;
	}

	/**
	 * Método privado que separa los elementos de la línea que le pasamos como 
	 * parámetro y crea un nuevo objeto de tipo Score. Puede lanzar o no excepciones
	 * @param line
	 * @return
	 * @throws ParseException
	 * @throws InvalidLineFormatException
	 */
	private Score parseLine(String line) throws ParseException, InvalidLineFormatException {
		ArgumentChecks.isTrue(line != null);
		ArgumentChecks.isTrue(!line.isBlank());
		
		String[] parts = line.split("---");
		String name = parts[0];
		String date1 = parts[1] + " " + parts[2];
		Date date = new SimpleDateFormat("dd/MM/yy HH:mm:ss").parse(date1);
		GameLevel level = parseGameLevel(parts[3]);
		Boolean result = parseBoolean(parts[4]);
		Long finalTime = Long.parseLong(parts[5]);
		return new Score(name, date, level, result, finalTime);
	}

	/**
	 * Método privado que devuelve true, false o lanza una excepción.
	 * @param string
	 * @return
	 * @throws InvalidLineFormatException
	 */
	private Boolean parseBoolean(String string) throws InvalidLineFormatException {
		if (string.equals("won")) {
			return true;
		} else if(string.equals("lost")){
			return false;
		}
		else {
			throw new InvalidLineFormatException(" " + lineNumber);
		}
	}

	/**
	 * Método privado que devuelve el nivel o una excepción
	 * @param string
	 * @return
	 * @throws InvalidLineFormatException
	 */
	private GameLevel parseGameLevel(String string) throws InvalidLineFormatException {
		if (string.equals("EASY")) {
			return GameLevel.SEA;
		} else if (string.equals("MEDIUM")) {
			return GameLevel.OCEAN;
		} else if(string.equals("HARD")){
			return GameLevel.PLANET;
		} else {
			throw new InvalidLineFormatException(" " + lineNumber);
		}
	}
}
