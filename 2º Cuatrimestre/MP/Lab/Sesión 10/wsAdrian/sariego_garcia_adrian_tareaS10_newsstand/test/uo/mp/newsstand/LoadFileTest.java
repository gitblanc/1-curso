package uo.mp.newsstand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.InvalidFileNameException;

public class LoadFileTest {
private Newsstand ns;
	
	@Before
	public void setUp() {
		ns = new Newsstand();
	}

	/**
	 * Given: Objeto NewsStand y nombre de fichero correcto
	 * When: se invoca a loadFile
	 * Then: se comprueba que se añadieron los objetos esperados
	 */
	@Test
	public void testLoadFileOk() throws InvalidFileNameException {
		ns.loadFile("publications.txt");
		assertEquals(8, ns.getPublications().size());
	}
	
	/**
	 * Given: Objeto NewsStand y nombre de fichero correcto
	 * When: se invoca a loadFile
	 * Then: se conprueba que se recive la excepcion esperada
	 */
	@Test
	(expected = InvalidFileNameException.class)
	public void testLoadFileWrongName() throws InvalidFileNameException {
		ns.loadFile("pucations.txt");
	}

}
