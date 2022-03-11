/**
 * 
 */
package uo.mp.battleship.ranking;

import java.util.Comparator;

/**
 * @author blanc
 *
 */
public class ScoreComparator implements Comparator<Score>{

	/**
	 * Método que compara dos objetos Score
	 * Si tienen el mismo nivel, se comparan por tiempo y si tienen el mismo tiempo
	 * se comparan por fecha
	 */
	@Override
    public int compare(Score o1, Score o2) {
        int diff = o1.getLevel().compareTo(o2.getLevel());
        if(diff == 0) {
            diff =  (int) (o1.getTime() - o2.getTime());
            if(diff == 0) {
            	return o1.getDate().compareTo(o2.getDate());
            }
        }
        return diff;
    }

	

}
