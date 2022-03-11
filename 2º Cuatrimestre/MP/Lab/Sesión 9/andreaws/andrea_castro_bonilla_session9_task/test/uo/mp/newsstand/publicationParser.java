/**
 * 
 */
package uo.mp.newsstand;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import uo.mp.newsstand.service.parsers.InvalidLineFormatException;
import uo.mp.newsstand.service.parsers.PublicationParser;

/**
 * @author Andrea Castro Bonilla
 *
 */
public class publicationParser {

	/*
	 * ESCENARIOS: 
	 * 	1. Recibe una lista vac�a. 
	 * 	2. Recibe una lista con cadena para magazine.
	 * 	3. Recibe una lista con cadena para newspaper. 
	 * 	4. Recibe una lista con ambas cadenas.
	 * 	5. Recibe una lista con una l�nea correcta y otra incorrecta, debido a: 
	 * 		- L�nea en blanco. 
	 * 		- Tipo desconocido. 
	 * 		- N�mero de campos incorrectos. 
	 * 		- Formato de n�mero incorrecto.
	 */
	

	/* - CASO 1 -
	 * GIVEN: recibe una lista vac�a
	 * THEN: se llama al m�todo parse()
	 * WHEN: InvalidLineFormatException
	 */
	@Test
	public void emptyListTest() throws InvalidLineFormatException {
		PublicationParser parser = new PublicationParser();
		List<String> lines = new LinkedList<>();

		parser.parse(lines);

		//Si la lista est� vac�a, el n�mero de l�neas = 0
		assertEquals(0, parser.getLineNumber());
	}

	
	/* - CASO 2 -
	 * GIVEN: recibe una lista con cadena para magazine.
	 * THEN: se llama al m�todo parse()
	 * WHEN: devuelve la lista creada correctamente
	 */
	@Test
	public void magazineTest() {
		PublicationParser parser = new PublicationParser();
		List<String> lines = new LinkedList<>();
		lines.add("magazine	PCWord	14	30	30");
		
		parser.parse(lines);
		
		assertEquals(1, parser.getLineNumber());
	}
	
	
	/* - CASO 3 -
	 * GIVEN: recibe una lista con cadena para newspaper.
	 * THEN: se llama al m�todo parse()
	 * WHEN: devuelve la lista creada correctamente
	 */
	@Test
	public void newspaperTest() {
		PublicationParser parser = new PublicationParser();
		List<String> lines = new LinkedList<>();
		lines.add("newspaper	El Mundo	4	10"); 

		parser.parse(lines);
		
		assertEquals(1, parser.getLineNumber());
	}
	
	
	/* - CASO 4 -
	 * GIVEN: recibe una lista con ambas cadenas.
	 * THEN: se llama al m�todo parse()
	 * WHEN: devuelve la lista creada correctamente
	 */
	@Test
	public void newspaperMagazineTest() {
		PublicationParser parser = new PublicationParser();
		List<String> lines = new LinkedList<>();
		lines.add("newspaper	El Mundo	4	10"); 
		lines.add("magazine	PCWord	14	30	30");

		parser.parse(lines);
		
		assertEquals(2, parser.getLineNumber());
	}
	
	
	/* - CASO 5 -
	 * GIVEN: recibe una lista con una l�nea correcta y otra incorrecta, 
	 * debido a un tipo desconocido.
	 * THEN: se llama al m�todo parse()
	 * WHEN: InvalidLineFormatException
	 */
	@Test
	public void unknowTypeTest() throws InvalidLineFormatException {
		List<String> lines = new LinkedList<>();
		lines.add("newspaper	El Mundo	4	10"); 
		lines.add("dossier	PCWord	14	30	30");
		
		fail("Deber�a haber fallado");
	}

}
