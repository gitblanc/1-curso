/**
 * 
 */
package uo.mp.battleship.ranking;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import uo.mp.battleship.session.GameLevel;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */

public class Score implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public Score(String name, Date date2, GameLevel level2, Boolean result2, Long finalTime) {
		setUserName(name);
		this.date = date2;
		this.level = level2;
		this.result = result2;
		this.time = finalTime;
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
	 * Método toString redefinido
	 */
	@Override
	public String toString() {
		String date = new SimpleDateFormat("dd/MM/yy").format(this.date);
		String time = new SimpleDateFormat("HH:mm:ss").format(this.date);

		return date + "---" + time + "---" + levelAssignement() + "---" + 
		getTheResult() + "---" + this.time;
	}

	/**
	 * Método público basado en el toString pero añadiendo el nombre del jugador
	 * @return
	 */
	public String toPersonalString() {
		return this.userName + "---" + toString();
	}

	/**
	 * Método que devuelve el resultado de la partida
	 * @return
	 */
	private String getTheResult() {
		return this.result ? "won" : "lost";
	}

	/**
	 * Método privado que asigna un Enum(nivel de dificultad) a un String
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
