/**
 * 
 */
package uo.mp.battleship.ranking;

import java.util.ArrayList;
import java.util.List;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class GameRanking {

	private List<Score> scores = new ArrayList<>();
	
	/**
	 * M�todo que a�ade el par�metro al final de la lista de puntuaciones
	 * @param score
	 */
	public void append(Score score) {
			ArgumentChecks.isTrue(score != null);
			scores.add(score);
	}
	
	/**
	 * M�todo que devuelve una copia de la lista de puntuaciones
	 * @return
	 */
	public List<Score> getRanking(){
		return new ArrayList<Score>(scores);
	}
	
	/**
	 * M�todo que devuelve una lista que contiene solo aquellas puntuaciones cuyo
	 * nombre de usuario coincide con el par�metro
	 * @param userName
	 * @return
	 */
	public List<Score> getRankingFor(String userName){
		List<Score> puntuations = new ArrayList<>();
		for(Score s: scores) {
			if(s.getUserName().equals(userName)) {
				puntuations.add(s);
			}
		}
		return puntuations;
	}
}
