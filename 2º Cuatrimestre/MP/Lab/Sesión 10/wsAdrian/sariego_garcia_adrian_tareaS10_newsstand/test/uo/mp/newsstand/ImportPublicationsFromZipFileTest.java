package uo.mp.newsstand;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.service.Newsstand;

public class ImportPublicationsFromZipFileTest {

private Newsstand ns;
	
	@Before
	public void setUp() {
		ns = new Newsstand();
	}

	/**
	 * Given: Objeto NewsStand y nombre de fichero correcto
	 * When: se invoca a importPublicationsFromZipFile
	 * Then: se conprueba que se añadieron los objetos esperados
	 */
	@Test
	public void testLoadFileOk() throws FileNotFoundException {
		ns.exportPublicationsToZipFile("publicationsgz.zip");
		ns.importPublicationsFromZipFile("publicationsgz.zip");
		assertEquals(8, ns.getPublications().size());
	}
	
	/**
	 * Given: Objeto NewsStand y nombre de fichero correcto
	 * When: se invoca a importPublicationsFromZipFile
	 * Then: se conprueba que se recive la excepcion esperada
	 */
	@Test
	(expected = FileNotFoundException.class)
	public void testLoadFileWrongName() throws FileNotFoundException {
		ns.importPublicationsFromZipFile("fdsfdsafdsf.zip");
	}

}
