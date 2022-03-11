package uo.mp.newsstand;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.sun.jdi.InvalidLineNumberException;

import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.InvalidFileNameException;
import uo.mp.newsstand.service.exception.NewsStandException;
import uo.mp.newsstand.service.parsers.InvalidLineFormatException;

public class LoadFile {

	private Newsstand ns = new Newsstand();
	

	/**
	 * GIVEN: un newstand
	 * WHEN: importamos un archivo qwue no existe
	 * THEN: salta un error de  InvalidFileNameException
	 * @throws FileNotFoundException
	 * @throws InvalidFileNameException
	 */
	@Test
	(expected =  InvalidFileNameException.class)
	public void loadFileNotExist() throws NewsStandException  {
		ns.loadFile("cfhgcfyjg");
		}
	
	/**
	 * GIVEN: un newstand
	 * WHEN: importamos un archivo que tiene lineas en blanco
	 * THEN: salta un error de  InvalidLineFormatException
	 * @throws FileNotFoundException
	 * @throws InvalidLineFormatException
	 */
	@Test
	(expected =  InvalidLineFormatException.class)
	public void loadFileEmptyLines() throws NewsStandException  {
		ns.loadFile("publicationsWithEmptyLines.txt");
		}
	
	/**
	 * GIVEN: un newstand
	 * WHEN: importamos un archivo que tiene numeros incorrectos
	 * THEN: salta un error de  InvalidLineFormatException
	 * @throws FileNotFoundException
	 * @throws InvalidLineFormatException
	 */
	@Test
	(expected =  InvalidLineFormatException.class)
	public void loadFileWrongNumbers() throws NewsStandException  {
		ns.loadFile("publicationsWithWrongNumbers.txt");
		}
	
	/**
	 * GIVEN: un newstand
	 * WHEN: importamos un archivo que tiene tipos desconocidos
	 * THEN: salta un error de  NewsStandException
	 * @throws NewsStandException
	 */
	@Test
	(expected =  NewsStandException.class)
	public void loadFileUnknownType() throws NewsStandException  {
		ns.loadFile("publicationsUnknownType.txt");
		}

}
