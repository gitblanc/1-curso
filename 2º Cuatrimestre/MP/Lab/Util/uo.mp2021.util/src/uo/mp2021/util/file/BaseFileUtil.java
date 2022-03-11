/**
 * 
 */
package uo.mp2021.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author blanc
 *
 */
public abstract class BaseFileUtil {

	protected abstract BufferedReader bufferReader1(String inFileName) throws FileNotFoundException;

	protected abstract BufferedWriter bufferWriter1(String outFileName) throws FileNotFoundException, IOException;

	public List<String> readLines(String inFileName) throws FileNotFoundException {// read
		List<String> res = new LinkedList<>();
		// Leer de un fichero:
		// 1 Crear el flujo de entrada(stream)
		// 2 Leer los datos
		// 3 Cerrar el flujo (aunque se produzca error)

		BufferedReader in = bufferReader1(inFileName);
		try {
			try {
				while (in.ready()) {// mientras haya líneas
					String line = in.readLine();
					res.add(line);
				}

			} finally {
				in.close();
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Error en escritura de fichero");

		} catch (IOException e) {
			throw new RuntimeException("Error en lectura de datos");
		}
		return res;
	}

	public void saveToFile(List<String> lines, String outFileName) throws FileNotFoundException {// write
		try {
			BufferedWriter out = bufferWriter1(outFileName);
			try {
				for (String str : lines) {
					out.write(str);
					out.newLine();
				}
			} finally {
				out.close();
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Error en escritura de fichero");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
