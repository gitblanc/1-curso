package uo.mp.util.file;



import java.util.LinkedList;
import java.util.List;

import uo.mp.exception.NotYetImplementedException;

/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil {

	public List<String> readLines(String inFileName) {
		List<String> res = new LinkedList<>();
		
		res.add("newspaper	La Nueva España	14	30");
		res.add("newspaper	El Mundo	4	10"); 
		res.add("magazine	Hola	14	30	7"); 
		res.add("magazine	PCWord	14	30	30");
		res.add("magazine	Diez Minuntos	4	10	7"); 
		res.add("magazine	El Mueble	4	10	30");
		res.add("magazine	Muy Interesante	8	20	7");
		res.add("magazine	Quo	8	10	30");
		
		return res;
	}

	public void writeLines(String outFileName, List<String> lines) {
		
		throw new NotYetImplementedException();
	}

}
