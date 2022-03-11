package uo.mp.s2.analyzer.model.wordanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s2.analyzer.model.WordAnalyzer;

public class firstRepeatedCharacterTest {
	
	/*
	 * Escenarios
	 * 
	 * 1- Hay un car�cter repetido consecutivo al principio de la palabra -> devuelve el car�cter repetido
	 * 2- No hay ning�n car�cter repetido consecutivo -> devuelve 0
	 * 3- Dos caracteres repetidos al final de la palabra -> devuelve el primer car�cter repetido
	 * 4- Hay un car�cter repetido al final -> devuelve el car�cter repetido
	 * 5- Todos los caracteres repetidos -> devuelve uno
	 * 6- Cadena vac�a -> devuelve 0
	 * 7- Hay m�s de un car�cter repetido pero no es consecutivo -> devuelve 0
	 */
	
	/**
	 * GIVEN	Hay un car�cter repetido consecutivo al principio de la palabra 
	 * WHEN		LLamamos a firstRepeatedCharacter
	 * THEN		Devuelve el primer car�cter
	 */
	@Test
	public void testFirstRepeatedCharacter1() {
		String word = "aabc";
		WordAnalyzer wa = new WordAnalyzer(word);
		assertEquals('a', wa.firstRepeatedCharacter());
	}

}
