/**
 * 
 */
package uo.mp.battleship.ranking;

import java.text.SimpleDateFormat;
import java.util.Date;

import uo.mp.battleship.session.GameLevel;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */

public class Score {
	private String userName;
	private GameLevel level;
	private long time;
	private Date date;
	private boolean result;

	/**
	 * Constructor
	 * @param userName
	 * @param level
	 * @param time
	 */
	public Score(String userName, GameLevel level, long time) {
		setUserName(userName);
		this.level = level;
		this.time = time;
		date = new Date();
		this.result = true;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	private void setUserName(String userName) {
		ArgumentChecks.isTrue(userName != null);
		ArgumentChecks.isTrue(!userName.isBlank());
		this.userName = userName;
	}

	/**
	 * @return the level
	 */
	public GameLevel getLevel() {
		return level;
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * M�todo toString redefinido
	 */
	@Override
	public String toString() {
		String date = new SimpleDateFormat("dd/MM/yy").format(this.date);
		String time = new SimpleDateFormat("HH:mm:ss").format(this.date);

		return date + "---" + time + "---" + levelAssignement() + "---" + 
		getTheResult() + "---" + this.time;
	}

	/**
	 * M�todo p�blico basado en el toString pero a�adiendo el nombre del jugador
	 * @return
	 */
	public String toPersonalString() {
		return this.userName + "---" + toString();
	}

	/**
	 * M�todo que devuelve el resultado de la partida
	 * @return
	 */
	private String getTheResult() {
		return this.result ? "won" : "lost";
	}

	/**
	 * M�todo privado que asigna un Enum(nivel de dificultad) a un String
	 * @return
	 */
	private String levelAssignement() {
		if (this.level.equals(GameLevel.SEA)) {
			return "EASY";
		} else if (this.level.equals(GameLevel.OCEAN)) {
			return "MEDIUM";
		} else {
			return "HARD";
		}
	}

}
