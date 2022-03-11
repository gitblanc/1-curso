/**
 * 
 */
package uo.mp.newsstand.service.parsers.publicationparser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.LinkedList;
import uo.mp.newsstand.service.parsers.PublicationParser;

/**
 * @author Antonio Castro
 *
 */
public class parseTest {
	
	
	/*
	 * Casos:
	 * 1- Lista  correcta
	 * 2- Lista con tipo desconocido
	 * 3- Lista con líneas vacías
	 * 4- Lista con números incorrectos
	 * 5- Lista con campos numéricos incorrectos
	 */
	
	List<String> correct;
	List<String> unknownType;
	List<String> emptyLines;
	List<String> wrongNumbers;
	List<String> wrongNumberFields;
	
	
	@Before
	public void setUp() {
		correct = new LinkedList<>();
		
		correct.add("newspaper	La Nueva EspaÃ±a	14	30");
		correct.add("newspaper	El Mundo	4	10"); 
		correct.add("magazine	Hola	14	30	7"); 
		correct.add("magazine	PCWord	14	30	30");
		correct.add("magazine	Diez Minuntos	4	10	7"); 
		correct.add("magazine	El Mueble	4	10	30");
		correct.add("magazine	Muy Interesante	8	20	7");
		correct.add("magazine	Quo	8	10	30");
		
		
		
		unknownType = new LinkedList<>();
		
		unknownType.add("newspaper	La Nueva EspaÃ±a	14	30");
		unknownType.add("newspaper	El Mundo	4	10"); 
		unknownType.add("magazine	Hola	14	30	7"); 
		unknownType.add("magazine	PCWord	14	30	30");
		unknownType.add("dosier	Diez Minuntos	4	10	7"); 
		unknownType.add("magazine	El Mueble	4	10	30");
		unknownType.add("magazine	Muy Interesante	8	20	7");
		unknownType.add("magazine	Quo	8	10	30");
		
		
		
		emptyLines = new LinkedList<>();
		
		emptyLines.add("newspaper	La Nueva EspaÃ±a	14	30");
		emptyLines.add(""); 
		emptyLines.add(""); 
		emptyLines.add("newspaper	El Mundo	4	10"); 
		emptyLines.add("magazine	Hola	14	30	7"); 
		emptyLines.add("magazine	PCWord	14	30	30");
		emptyLines.add("magazine	Diez Minuntos	4	10	7"); 
		emptyLines.add("magazine	El Mueble	4	10	30");
		emptyLines.add("magazine	Muy Interesante	8	20	7");
		emptyLines.add("magazine	Quo	8	10	30");
		
		
		
		wrongNumbers = new LinkedList<>();
		
		wrongNumbers.add("newspaper	La Nueva EspaÃ±a	14	30");
		wrongNumbers.add("newspaper	El Mundo	4k	10"); 
		wrongNumbers.add("magazine	Hola	14	30	7"); 
		wrongNumbers.add("magazine	PCWord	14	30	30");
		wrongNumbers.add("magazine	Diez Minuntos	4	10	7"); 
		wrongNumbers.add("magazine	El Mueble	4	10	30");
		wrongNumbers.add("magazine	Muy Interesante	8	20	7");
		wrongNumbers.add("magazine	Quo	8	10	30");
		
		
		
		wrongNumberFields = new LinkedList<>();
		
		wrongNumberFields.add("newspaper	La Nueva EspaÃ±a	14	30");
		wrongNumberFields.add("newspaper	El Mundo	0"); 
		wrongNumberFields.add("magazine	Hola	14	30	7"); 
		wrongNumberFields.add("magazine	PCWord	14	30	30");
		wrongNumberFields.add("magazine	Diez Minuntos	4	10	7"); 
		wrongNumberFields.add("magazine	El Mueble	4	10	30");
		wrongNumberFields.add("magazine	Muy Interesante	8	20	7");
		wrongNumberFields.add("magazine	Quo	8	10	30");
	}
	
	
	
	/**
	 * GIVEN una lista de líneas con formato correcto
	 * WHEN se llama a parse
	 * THEN se añaden todas las líneas correctamente
	 */
	@Test
	public void correctTest() {
		PublicationParser p = new PublicationParser();
		assertEquals(8, p.parse(correct).size());
	}
	
	
	
	/**
	 * GIVEN una lista de líneas con líneas de tipo desconocido
	 * WHEN se llama a parse
	 * THEN se añaden todas las líneas que son correctas (7)
	 */
	@Test
	public void unknownTypeTest() {
		PublicationParser p = new PublicationParser();
		assertEquals(7, p.parse(unknownType).size());
	}
	
	
	
	/**
	 * GIVEN una lista de líneas con líneas vacías
	 * WHEN se llama a parse
	 * THEN se añaden todas las líneas que son correctas (8)
	 */
	@Test
	public void emptyLinesTest() {
		PublicationParser p = new PublicationParser();
		assertEquals(8, p.parse(emptyLines).size());
	}

	
	
	
	/**
	 * GIVEN una lista de líneas con campos incorrectos
	 * WHEN se llama a parse
	 * THEN se añaden todas las líneas que son correctas (7)
	 */
	@Test
	public void wrongNumbersTest() {
		PublicationParser p = new PublicationParser();
		assertEquals(7, p.parse(wrongNumbers).size());
	}
	
	
	
	/**
	 * GIVEN una lista de líneas con líneas con número de campos incorrecto
	 * WHEN se llama a parse
	 * THEN se añaden todas las líneas que son correctas (7)
	 */
	@Test
	public void wrongNumberFieldsTest() {
		PublicationParser p = new PublicationParser();
		assertEquals(7, p.parse(wrongNumberFields).size());
	}
}
