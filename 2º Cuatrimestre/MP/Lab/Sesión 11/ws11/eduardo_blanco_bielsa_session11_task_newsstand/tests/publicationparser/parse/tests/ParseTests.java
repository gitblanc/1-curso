/**
 * 
 */
package publicationparser.parse.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uo.mp.newsstand.service.parsers.PublicationParser;

/**
 * @author blanc
 *
 */
public class ParseTests {

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista vacia
	 * THEN salta excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testParse1() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		pp.parse(stringList);
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con dos revistas
	 * THEN el parser devuelve una lista con dos revistas
	 */
	@Test
	public void testParse2() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("magazine\tpatata\t32\t32\t76");
		stringList.add("magazine\taceituna\t32\t31\t76");
		assertEquals(2, pp.parse(stringList).size());
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con un periódico
	 * THEN el parser devuelve una lista con el periódico
	 */
	@Test
	public void testParse3() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("newspaper\tpatata\t32\t32");
		assertEquals(1, pp.parse(stringList).size());
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con una revista y un periódico
	 * THEN el parser devuelve una lista  con una revista y un periódico
	 */
	@Test
	public void testParse4() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("magazine\tpatata\t32\t32\t76");
		stringList.add("newspaper\tpatata\t32\t32");
		assertEquals(2, pp.parse(stringList).size());
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con una revista y un blanco
	 * THEN el parser devuelve una lista  con una revista 
	 */
	@Test
	public void testParse5() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("magazine\tpatata\t32\t32\t76");
		stringList.add("");
		assertEquals(1, pp.parse(stringList).size());
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con una revista y un tipo deconocido
	 * THEN el parser devuelve una lista con una revista 
	 */
	@Test
	public void testParse6() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("magazine\tpatata\t32\t32\t76");
		stringList.add("smartphone\tpatata\t32\t32\t76");
		assertEquals(1, pp.parse(stringList).size());
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con una revista incorrecta y otra correcta
	 * THEN el parser devuelve una lista con  una revista correcta
	 */
	@Test
	public void testParse7() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("magazine\tpatata\t32\t76");
		stringList.add("magazine\tpatata\t32\t32\t76");
		assertEquals(1, pp.parse(stringList).size());
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con una revista incorrecta y otra correcta
	 * THEN el parser devuelve una lista con  una revista correcta
	 */
	@Test
	public void testParse8() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("magazine\tpatata\t32\t32\t76");
		stringList.add("magazine\tpatata\tAA\t32\t76");
		assertEquals(1, pp.parse(stringList).size());
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con un periódico y un blanco
	 * THEN el parser devuelve una lista  con un periódico 
	 */
	@Test
	public void testParse9() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("newspaper\tpatata\t32\t76");
		stringList.add("");
		assertEquals(1, pp.parse(stringList).size());
	}

	/**
	 * GIVEN
	 * WHEN se llama al parser con una lista con una periódico incorrecto y otra correcto
	 * THEN el parser devuelve una lista con  una periódico correcto
	 */
	@Test
	public void testParse10() {
		PublicationParser pp = new PublicationParser();
		List<String> stringList = new ArrayList<>();
		stringList.add("newspaper\tpatata\t32\t76");
		stringList.add("newspaper\\tpatata\\tAA\\t76");
		assertEquals(1, pp.parse(stringList).size());
	}
}
