package uo.mp.battleship.board;

public class BoardBuilder {
	public static final int MIN_SIZE = 5;
	public static final int MAX_SIZE = 15;
	public static final int DEFAULT_SIZE = 10;

	public int size;

	/**
	 * Almacena en el atributo size de la clase, el tama?o del array que se va a
	 * crear con el valor que recibe como par?metro. Devuelve el propio objeto
	 * BoardBuilder.
	 * 
	 * @param size
	 * @return
	 */
	public BoardBuilder of(int size) {
		setSize(size);
		return this;
	}

	/**
	 * Devuelve un nuevo array cuadrado de enteros con el contenido fijo que se
	 * muestra en Array 1. Deber?a estar invocado antes el
	 * m?todo of para dar un valor correcto al atributo size. Si no se ha realizado
	 * esto, se deber? lanzar una IllegalStateException
	 * 
	 * @return
	 */
	public int[][] build() {
		int[][] arrayInicial = new int[DEFAULT_SIZE][DEFAULT_SIZE];
		arrayInicial[0][0] = 1;
		arrayInicial[0][2] = 1;
		arrayInicial[0][4] = 1;
		arrayInicial[0][6] = 1;

		arrayInicial[2][0] = 2;
		arrayInicial[2][1] = 2;
		arrayInicial[2][3] = 2;
		arrayInicial[2][4] = 2;
		arrayInicial[2][6] = 2;
		arrayInicial[2][7] = 2;

		arrayInicial[4][0] = 3;
		arrayInicial[4][1] = 3;
		arrayInicial[4][2] = 3;
		arrayInicial[4][4] = 3;
		arrayInicial[4][5] = 3;
		arrayInicial[4][6] = 3;

		arrayInicial[6][4] = 4;
		arrayInicial[6][5] = 4;
		arrayInicial[6][6] = 4;
		arrayInicial[6][7] = 4;

		return arrayInicial;
	}

	private void setSize(int size) {
		if (size >= MIN_SIZE && size <= MAX_SIZE) {
			this.size = size;
		} else {
			this.size = DEFAULT_SIZE;
		}
	}

}