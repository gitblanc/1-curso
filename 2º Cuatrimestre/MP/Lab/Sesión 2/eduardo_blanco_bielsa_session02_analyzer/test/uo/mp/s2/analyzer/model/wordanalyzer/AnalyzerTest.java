package uo.mp.s2.analyzer.model.wordanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s2.analyzer.model.WordAnalyzer;

public class AnalyzerTest {

	/*
	 * 1- Analizador con palabra de varios caracteres
	 * 2- Analizador con palabra de un único carácter
	 *
	 *	 	pruebas de robustez
	 * 3- Analizador con palabra vacía
	 * 4- Analizador con null en lugar de palabra
	 */
	/**
	 * GIVEN
	 * WHEN		se crea el analizador con una palabra vacía
	 * THEN		salta excepción IllegalArgumentException
	 */
	
//	public void emptyWord() {	
//		try {
//			new WordAnalyzer("");
//			fail("Debería haber fallado");
//		}
//		catch(IllegalArgumentException e) {
//			assertEquals("La palabra está vacía", e.getMessage());
//		}
//	}
	//1- Analizador con palabra de varios caracteres
	@Test
	public void testAnalyzer1() {
		WordAnalyzer an = new WordAnalyzer("abbcd");
		assertEquals('b', an.firstRepeatedCharacter());
		assertEquals('b', an.firstMultipleCharacter());
		assertEquals(1, an.countGroupsOfRepeatedCharacters());
	}
	
	//2- Analizador con palabra de un único carácter
	@Test
	public void testAnalyzer2() {
		WordAnalyzer an = new WordAnalyzer("a");
		assertEquals(0, an.firstRepeatedCharacter());
		assertEquals(0, an.firstMultipleCharacter());
		assertEquals(0, an.countGroupsOfRepeatedCharacters());
	}
	
	//3- Analizador con palabra vacía
	@Test
	public void testAnalyzer3() {
		try {
			WordAnalyzer an = new WordAnalyzer("");
			fail("Esperaba excepción");
			}
			catch(IllegalArgumentException e) {
				assertEquals("Cadena vacía", e.getMessage());
			}
	}
	
	//4- Analizador con null en lugar de palabra
	@Test
	public void testAnalyzer4() {
		try {
		WordAnalyzer an = new WordAnalyzer(null);
		fail("Esperaba excepción");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Esperaba palabra y fue null", e.getMessage());
		}
		
	}

}
