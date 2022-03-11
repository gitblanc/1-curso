package uo.mp.s2.analyzer.model.wordanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s2.analyzer.model.WordAnalyzer;

public class firstRepeatedCharacterTest {
	
	/*
	 * Escenarios
	 * 
	 * 1- Hay un carácter repetido consecutivo al principio de la palabra -> devuelve el carácter repetido
	 * 2- No hay ningún carácter repetido consecutivo -> devuelve 0
	 * 3- Dos caracteres repetidos al final de la palabra -> devuelve el primer carácter repetido
	 * 4- Hay un carácter repetido al final -> devuelve el carácter repetido
	 * 5- Todos los caracteres repetidos -> devuelve uno
	 * 6- Cadena vacía -> devuelve 0
	 * 7- Hay más de un carácter repetido pero no es consecutivo -> devuelve 0
	 */
	
	/**
	 * GIVEN	Hay un carácter repetido consecutivo al principio de la palabra 
	 * WHEN		LLamamos a firstRepeatedCharacter
	 * THEN		Devuelve el primer carácter
	 */
	@Test
	public void testFirstRepeatedCharacter1() {
		String word = "aabc";
		WordAnalyzer wa = new WordAnalyzer(word);
		assertEquals('a', wa.firstRepeatedCharacter());
	}

}
