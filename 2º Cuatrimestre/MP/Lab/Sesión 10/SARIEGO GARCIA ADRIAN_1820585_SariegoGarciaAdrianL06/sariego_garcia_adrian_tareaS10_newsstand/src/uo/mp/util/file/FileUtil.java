package uo.mp.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil {

	public List<String> readLines(String inFileName) throws FileNotFoundException {
		List<String> res = new LinkedList<>();
		// 1 - Crear el flujo de entrada (stream)
		BufferedReader in = new BufferedReader(new FileReader(inFileName));
		// 2 - Leer los datos
		try {
			try {
				while(in.ready()) {
					String line = in.readLine();
					res.add(line);
				}
			} finally {
				// 3 - Cerrar el flujo (aunque se produzca error)
				in.close(); //esta instruccion soloi se ejecuta si se llega aqui
				// Para asegurarme ponemos el try, finally 
			}
		} catch(IOException e) {// Vuelvo a lanzar la misma para separarla de las IOException,
			// Si no, solo lanzaria la IOException, ya q es la padre de FileNotFoundException
		throw new RuntimeException("Error en lectura de datos");
		}
		return res;
		
//		res.add("newspaper	La Nueva España	14	30");
//		res.add("newspaper	El Mundo	4	10"); 
//		res.add("magazine	Hola	14	30	7"); 
//		res.add("magazine	PCWord	14	30	30");
//		res.add("magazine	Diez Minuntos	4	10	7"); 
//		res.add("magazine	El Mueble	4	10	30");
//		res.add("magazine	Muy Interesante	8	20	7");
//		res.add("magazine	Quo	8	10	30");	
//		return res;
	}

	public void writeLines(String outFileName, List<String> lines) {	
		try {
			// 1 - Crear el flujo
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName)); 
			try {// 2 - Escribir
				for(String line:lines) {
					out.write(line);
					out.newLine();
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
