/**
 * 
 */
package uo.mp.battleship.session;

import java.util.List;

import uo.mp.battleship.ranking.Score;

/**
 * @author blanc
 *
 */
public interface SessionInteractor {
	
	GameLevel askGameLevel();
	String askUserName();
	int askNextOption();
	boolean askDebugMode();
	boolean doYouWantToRegisterYourScore() ;
	void showRanking(List<Score> ranking);
	void showPersonalRanking(List<Score> ranking);
	void showErrorMessage(String message);
	void showFatalErrorMessage(String message);
	
}
