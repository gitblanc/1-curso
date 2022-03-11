package uo.mp.s2.bugs.model;

/**
 * Clase que analiza palabras
 */
public class WordAnalyzer {
	
	/**
	 * La palabra a analizar
	 */
	private String word;

	/**
	 * Constructor que crea un objeto analizador con la palabra recibida
	 * 
	 * @param aWord  La palabra a ser analizada
	 */
	public WordAnalyzer(String aWord) {
		word = aWord;
	}

	/**
	 * Obtiene el primer carácter repetido. Un carácter está <i>repetido</i> si
	 * aparece al menos dos veces en posiciones adyacentes.
     *    Por ejemplo, 'l' está repetida  en  "pollo", pero 'o' no está.
	 * 
	 * @return el primer caracter repetido, o 0 si no lo encuentra
	 */
	public char firstRepeatedCharacter() {
		for (int i = 0; i < word.length()-1; i++) {
			char ch = word.charAt(i);
			if (ch == word.charAt(i + 1))
				return ch;
		}
		return 0;
	}

	/**
	 * Obtiene el primer carácter múltiple que aparece. Un carácter es
	 * <i>múltiple</i> si aparece al menos dos veces en la palabra, 
	 * no necesariamente en posiciones adyacentes. 
	 *    Por ejemplo, 'o' y 'l' son múltiples en "pollo", pero 'p' no es.
	 * 
	 * @return el primer carácter múltiple repetido o 0 si no lo encuentra
	 */
	public char firstMultipleCharacter() {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (find(ch, i+1) >= 0)
				return ch;
		}
		return 0;
	}

	/**
	 * Encuentra la posición de un carácter en la palabra, 
	 * comenzando en una posición específica.
	 *  
	 * @param c El carácter que se quiere encontrar
	 * @param pos La posición de comienzo
	 * @return La posición del carácter en la palabra,
	 *         ó -1 si el carácetr no está en la palabra
	 */
	private int find(char c, int pos) {
		for (int i = pos; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Cuenta los grupos de caracteres repetidos. Por ejemplo, "mississippi!!!"
	 * tiene cuatro grupos: ss, ss, pp y !!!.
	 * 
	 * @return el número de grupos de caracteres repetidos
	 */
	public int countGroupsOfRepeatedCharacters() {
		int count = 0;
		for (int i = 1; i < word.length() - 1; i++) {
			if (word.charAt(i) == word.charAt(i + 1)) {  // encuentra repetición
				if (word.charAt(i - 1) != word.charAt(i) ) 
					count++;
			}
		}
		return count;
	}

}