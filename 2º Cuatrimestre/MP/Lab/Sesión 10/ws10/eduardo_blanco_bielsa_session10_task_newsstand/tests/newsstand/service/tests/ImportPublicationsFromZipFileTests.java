/**
 * 
 */
package newsstand.service.tests;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.service.Newsstand;

/**
 * @author blanc
 *
 */
public class ImportPublicationsFromZipFileTests {
	Newsstand n1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		n1 = new Newsstand();
	}

	/**
	 * Casos:
	 * 
	 * 1 Nombre del fichero es nulo -> salta excepci?n
	 * 2 Archivo no encontrado -> se recoge la excepci?n
	 */
	
	/**
	 * GIVEN un objeto newsstand
	 * WHEN Nombre del fichero es nulo
	 * THEN salta excepci?n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testImportPublicationsFromZipFile1() {
		try {
			n1.importPublicationsFromZipFile(null);
		} catch (FileNotFoundException e) {
		}
	}
	
	/**
	 * GIVEN un objeto newsstand
	 * WHEN Archivo no encontrado
	 * THEN se recoge la excepci?n
	 */
	@Test
	public void testImportPublicationsFromZipFile2() {
		try {
			n1.importPublicationsFromZipFile("patata.gz");
		} catch (FileNotFoundException e) {
		}
	}

}
