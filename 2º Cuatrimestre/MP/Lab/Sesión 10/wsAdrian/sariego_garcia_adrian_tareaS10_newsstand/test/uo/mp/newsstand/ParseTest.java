package uo.mp.newsstand;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.parsers.PublicationParser;

public class ParseTest {

	private PublicationParser pp;

	@Before
	public void setUp() {
		pp = new PublicationParser();
	}

	/**
	 * Given: una lista de strings con formato correcto y un objeto publication parser
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que se añadieron los objetos
	 */
	@Test
	public void testParserOkList() {
		List<String> res = new ArrayList<>();

		res.add("newspaper	La Nueva España	14	30");
		res.add("magazine	PCWord	14	30	30");

		List<Publication> pu = pp.parse(res);
		
		assertEquals(2, pu.size());;
	}
	
	/**
	 * Given: una lista de strings con daota incorrectos en la revista
	 *  y un objeto publication parser
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que se añadieron los objetos
	 */
	@Test
	public void testParserNotOkMagazine() {
		List<String> res = new ArrayList<>();

		res.add("newspaper	La Nueva España	14	30");
		res.add("magazine	PCWord	14Ei	30	30");

		List<Publication> pu = pp.parse(res);
		
		assertEquals(1, pu.size());;
	}
	
	/**
	 * Given: una lista de strings con daota incorrectos en la revista
	 *  y un objeto publication parser
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que se añadieron los objetos
	 */
	@Test
	public void testParserNotOkNumberOFFieldsMagazine() {
		List<String> res = new ArrayList<>();

		res.add("newspaper	La Nueva España	14	30");
		res.add("magazine	PCWord	30	30");

		List<Publication> pu = pp.parse(res);
		
		assertEquals(1, pu.size());;
	}
	
	/**
	 * Given: una lista de strings con una linea vacia y un objeto publication parser
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que se añadieron los objetos y se ignoró la linea en blanco
	 */
	@Test
	public void testParserEmtyLine() {
		List<String> res = new ArrayList<>();

		res.add("newspaper	La Nueva España	14	30");
		res.add("magazine	PCWord	14	30	30");
		res.add("\n");

		List<Publication> pu = pp.parse(res);
		
		assertEquals(2, pu.size());;
	}
	
	/**
	 * Given: una lista de strings con una linea vacia y un objeto publication parser
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que se añadieron los objetos y se ignoró la linea en blanco
	 */
	@Test
	public void testParserWrongDataNewspaper() {
		List<String> res = new ArrayList<>();

		res.add("newspaper	La Nueva España	 kyuig	 iu	14	30");
		res.add("magazine	PCWord	14	30	30");
		res.add("\n");

		List<Publication> pu = pp.parse(res);
		
		assertEquals(1, pu.size());;
	}
	
	/**
	 * Given: una lista de strings con una linea vacia y un objeto publication parser
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que se añadieron los objetos y se ignoró la linea en blanco
	 */
	@Test
	public void testParserWrongFielsNewspaper() {
		List<String> res = new ArrayList<>();

		res.add("newspaper	La Nueva España	14	30nc2cie2");
		res.add("magazine	PCWord	14	30	30");

		List<Publication> pu = pp.parse(res);
		
		assertEquals(1, pu.size());;
	}

}
