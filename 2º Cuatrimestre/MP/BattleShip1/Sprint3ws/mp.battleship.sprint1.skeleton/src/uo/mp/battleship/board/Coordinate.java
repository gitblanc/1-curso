package uo.mp.battleship.board;

public class Coordinate {
	private int col;
	private int row;

	/**
	 * Crea un objeto de tipo Coordinate, a partir de los par?metros x para la
	 * columna, e y para la fila.
	 * 
	 * @param col
	 * @param row
	 */
	public Coordinate(int col, int row) {
		setCol(col);
		setRow(row);
	}

	/**
	 * Crea un objeto Coordenada a partir de la etiquete que representa la columna
	 * (x), que es una letra, y la etiqueta que representa la fila, que es un n?mero
	 * (y).
	 * 
	 * @param col
	 * @param row
	 */
	public Coordinate(char col, int row) {
		setCol(col - 65); // por el ASCII (A = 65)
		setRow(row - 1);
	}

	/**
	 * Devuelve el valor de la columna.
	 * 
	 * @return
	 */
	public int getCol() {
		return this.col;
	}

	/**
	 * Devuelve el valor de la fila.
	 * 
	 * @return
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Sobreescribe el m?todo toString y devuelve el valor de las coordenadas con el
	 * formato: Coordenada [ x = 0, y = 1 ]
	 */
	@Override
	public String toString() {
		String aucol = "Coordenada [ col = " + getCol() + " , row = " + getRow() + " ]";
		return aucol;
	}

	/**
	 * Devuelve el valor de las coordenadas en un formato m?s adecuado para el
	 * usario. En lugar de Coordenada [x = 1, y = 1] este m?todo devuelve B-2
	 * 
	 * @return
	 */
	public String toUserString() {
		return (char) (this.col + 65) + " - " + (this.row + 1);
	}

	private void setCol(int col) {
		this.col = col;
	}

	private void setRow(int row) {
		this.row = row;
	}

	/**
	 * Devuelve true si todos los campos de ambos objetos son iguales.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
