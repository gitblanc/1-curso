package uo.mp.s2.bugs.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uo.mp.s2.bugs.model.WordAnalyzer;

/**
 * Aplication que muestra diferentes operaciones con cadenas de caracteres
 */
public class Application {
	
		
	/**
	 * Pide una palabra al usuario y la analiza
	 */
	public void run() {
		System.out.print("Escribe una palabra: ");
		String word = readString();
		WordAnalyzer analyzer = new WordAnalyzer(word);
		System.out.println("Primer carácter repetido: " 
		                    + analyzer.firstRepeatedCharacter());
		System.out.println("Primer carácter múltiple: " 
		                    + analyzer.firstMultipleCharacter());
		System.out.println("Grupos de caracteres repetidos: " 
		                    + analyzer.countGroupsOfRepeatedCharacters());

		System.out.println();
		System.out.println("Primer carácter múltiple en \"pollo\": " +
				new WordAnalyzer("pollo").firstMultipleCharacter());
		System.out.println("Grupos de caracteres repetidos en \"aabbcdaaaabb\":" 
		 + new WordAnalyzer("aabbcdaaaabb").countGroupsOfRepeatedCharacters());
		System.out.print("Primer carácter repetido en \"antes\": ");
		System.out.println(new WordAnalyzer("antes").firstRepeatedCharacter());		
	}
	
	/**
	 * Lee un string de la consola.
	 * Este codigo NO DEBE ENTERDERSE AHORA se verá más adelante (tema 7).
	 * @return El string escrito por el usuario
	 */
	private String readString() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		try {
		  str = br.readLine();
		}
		catch(IOException e) {
			System.err.println("Error reading the string.");
			System.exit(1);
		}
		return str;
	}

}