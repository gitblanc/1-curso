package eduardo_blanco_bielsa_session02_task_seatmanager;

import java.util.ArrayList;

/**
 * Clase SeatManager
 * @author Eduardo Blanco Bielsa
 * @date 13/02/2021
 *
 */
public class SeatManager {
	public static final int MAX_ROWS = 10;
	public static final int MAX_COLUMNS = 4;

	private Person[][] people;

	/**
	 * Constructor sin par�metros que establece el array a MAX_ROWS y MAX_COLUMNS
	 */
	public SeatManager() {
		this.people = new Person[MAX_ROWS][MAX_COLUMNS];
	}

	/**
	 * M�todo bookSeat que sienta pasajeros y devuelve un boolean
	 */
	public boolean bookSeat(Person person, int row, int column) {
		isTrue(person != null, "Error: person inv�lida");
		isTrue(row >= 0 && row <= MAX_ROWS, "Error: row inv�lida");
		isTrue(column >= 0 && column <= MAX_COLUMNS, "Error: column inv�lida");

		if (people[row][column] == null || ( people[row][column] != null && 
				people[row][column].getAge() >= Person.ADULTHOOD_AGE
				 && people[row][column].getAge() < Person.RETIREMENT_AGE)) {
			this.people[row][column] = person;
			return true;
		}
		else {
			return false;
		}

	}
	
	/**
	 * M�todo findPassengersByAge que devuelve un ArrayList de personas
	 * @param minAge
	 * @param maxAge
	 * @return
	 */
	public ArrayList<Person> findPassengersByAge(double minAge, double maxAge){
		isTrue(minAge >= Person.MIN_AGE && minAge <= Person.MAX_AGE && maxAge > minAge, "Error: minAge inv�lida");
		isTrue(maxAge <= Person.MAX_AGE, "Error: maxAge inv�lida");
		
		ArrayList<Person> aux = new ArrayList<Person>();
		for(int i = 0; i < people.length; i++) {
			for(int j = 0; j < people[i].length; j++) {
				if(people[i][j] != null && (i % 2 == 0 || i == 0) 
						&& people[i][j].getAge() >= minAge
						&& people[i][j].getAge() <= maxAge ) { // como no especificasteis inclu� la fila 0 como par
					aux.add(people[i][j]);
				}
			}
		}
		return aux;
	}

	/**
	 * M�todo isTrue que eval�a una condici�n y salta una excepci�n si no se cumple
	 * @param cond
	 * @param msg
	 */
	private static void isTrue(boolean cond, String msg) {
		if (!cond) {
			throw new IllegalArgumentException(msg);
		}
	}
}
