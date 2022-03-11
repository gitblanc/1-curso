package uo.mp.s2.analyzer.model.wordanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s2.analyzer.model.WordAnalyzer;

public class AnalyzerTest {

	/*
	 * 1- Analizador con palabra de varios caracteres
	 * 2- Analizador con palabra de un �nico car�cter
	 *
	 *	 	pruebas de robustez
	 * 3- Analizador con palabra vac�a
	 * 4- Analizador con null en lugar de palabra
	 */
	/**
	 * GIVEN
	 * WHEN		se crea el analizador con una palabra vac�a
	 * THEN		salta excepci�n IllegalArgumentException
	 */
	
//	public void emptyWord() {	ANTIGUA FORMA
//		try {
//			new WordAnalyzer("");
//			fail("Deber�a haber fallado");
//		}
//		catch(IllegalArgumentException e) {
//			assertEquals("La palabra est� vac�a", e.getMessage());
//		}
//	}
	@Test
	(expected = IllegalArgumentException.class)
	public void emptyWord() {
		new WordAnalyzer("");
	}

}
