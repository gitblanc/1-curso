/**
 * 
 */
package newsstand.service.tests;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.InvalidFileNameException;

/**
 * @author blanc
 *
 */
public class LoadFileTests {
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
	 * 2 Nombre del fichero vac?o -> salta excepci?n
	 * 3 Longitud del nombre inv?lida -> se recoge la excepci?n
	 * 4 Archivo no encontrado -> se recoge la excepci?n
	 */
	
	/**
	 * GIVEN un objeto NewsStand
	 * WHEN nombre del fichero es nulo
	 * THEN salta excepci?n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testLoadFile1() {
		Newsstand n1 = new Newsstand();
		try {
			n1.loadFile(null);
		} catch (InvalidFileNameException e) {
		}
	}
	
	/**
	 * GIVEN un objeto NewsStand
	 * WHEN nombre del fichero es vac?o
	 * THEN salta excepci?n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testLoadFile2() {
		Newsstand n1 = new Newsstand();
		try {
			n1.loadFile("");
		} catch (InvalidFileNameException e) {
		}
	}
	
	/**
	 * GIVEN un objeto NewsStand
	 * WHEN Longitud del nombre inv?lida
	 * THEN se recoge la excepci?n
	 */
	@Test
	public void testLoadFile3() {
		
		try {
			n1.loadFile("das");
		} catch (InvalidFileNameException e) {
		}
	}
	
	/**
	 * GIVEN un objeto NewsStand
	 * WHEN Archivo no encontrado
	 * THEN se recoge la excepci?n
	 */
	@Test
	public void testLoadFile4() {
		Newsstand n1 = new Newsstand();
			try {
				n1.loadFile("patata.txt");
			} catch (InvalidFileNameException e) {
			}
	}

}
