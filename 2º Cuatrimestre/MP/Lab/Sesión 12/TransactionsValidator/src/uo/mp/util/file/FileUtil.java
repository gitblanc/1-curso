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

	public List<String> loadLines(String inFileName) throws FileNotFoundException {
		List<String> res = new LinkedList<>();
		// Leer de un fichero:
		// 1 Crear el flujo de entrada(stream)
		// 2 Leer los datos
		// 3 Cerrar el flujo (aunque se produzca error)

		BufferedReader in = new BufferedReader(new FileReader(inFileName));
		try {
			try {
				while (in.ready()) {// mientras haya líneas
					String line = in.readLine();
					res.add(line);
				}

			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error en lectura de datos");
		}
		return res;
	}

	public void saveToFile(List<String> lines, String outFileName) throws FileNotFoundException {
		try {
		BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
		try {
			for (String str : lines) {
				out.write(str);
				out.newLine();
			}
		} finally {
			out.close();
		}
		}catch(FileNotFoundException e){
			throw new FileNotFoundException("Error en escritura de fichero");
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}

}

