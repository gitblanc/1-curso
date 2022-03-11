package uo.mp.newsstand;


import java.io.FileNotFoundException;

import org.junit.Test;

import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.InvalidFileNameException;

public class ImportPublicationsFromZipFile {

	private Newsstand ns = new Newsstand();
	
	/**
	 * GIVEN: un newstand
	 * WHEN: importamos un archivo qwue no existe
	 * THEN: salta un error de  FileNotFoundException
	 * @throws FileNotFoundException
	 * @throws InvalidFileNameException
	 */
	@Test
	(expected = FileNotFoundException.class)
	public void zipNotExist() throws FileNotFoundException, InvalidFileNameException {
		ns.importPublicationsFromZipFile("hdfshdfhfd");
	}

}
