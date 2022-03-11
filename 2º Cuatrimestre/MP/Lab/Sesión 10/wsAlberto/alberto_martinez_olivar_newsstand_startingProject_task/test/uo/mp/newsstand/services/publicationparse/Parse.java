package uo.mp.newsstand.services.publicationparse;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.parsers.InvalidLineFormatException;
import uo.mp.newsstand.service.parsers.PublicationParser;

public class Parse {

	private PublicationParser pp = new PublicationParser();
	
	/**
	 * GIVEN una lista con una revista en forma de string
	 * WHEN llamamos al parse()
	 * THEN crea una lista con la revista como revista
	 */
	@Test
	public void testMagazineChain() {
		List<String> list = new ArrayList<String>();
		list.add("magazine	Diez Minutos	4	10	7");
		List<Publication>ret = pp.parse(list);
		assertEquals(ret.get(0), new Magazine("Diez Minutos", 4	,10, 7));
	}
	
	/**
	 * GIVEN una lista con un periodico en forma de string
	 * WHEN llamamos al parse()
	 * THEN crea una lista con el periodico como periodico
	 */
	@Test
	public void testNewspaperChain() {
		List<String> list = new ArrayList<String>();
		list.add("newspaper	Diez Minutos	4	10");
		List<Publication>ret = pp.parse(list);
		assertEquals(ret.get(0), new Newspaper("Diez Minutos", 4	,10));
	}
	
	/**
	 * GIVEN una lista con una revista y un periodico en forma de string
	 * WHEN llamamos al parse()
	 * THEN crea una lista con la revista y el periodico en sus formas
	 */
	@Test
	public void testNewspaperAndMagazineChain() {
		List<String> list = new ArrayList<String>();
		list.add("magazine	Quo	4	10	7");
		list.add("newspaper	Diez Minutos	4	10");
		List<Publication>ret = pp.parse(list);
		assertEquals(ret.get(1), new Newspaper("Diez Minutos", 4	,10));
		assertEquals(ret.get(0), new Magazine("Quo", 4	,10, 7));
	}
	
	/**
	 * GIVEN una lista con una revista y un periodico en forma de string
	 *       la revista mal indicada
	 * WHEN llamamos al parse()
	 * THEN salta una excepcion de tipo linea invalida
	 */
	@Test
	(expected = InvalidLineFormatException.class)
	public void testOneInvalid() throws InvalidLineFormatException {
		List<String> list = new ArrayList<String>();
		list.add("otro	Quo	4	10	7 ");
		list.add("newspaper	Diez Minutos	4	10");
		pp.parse(list);
		
	}

}
