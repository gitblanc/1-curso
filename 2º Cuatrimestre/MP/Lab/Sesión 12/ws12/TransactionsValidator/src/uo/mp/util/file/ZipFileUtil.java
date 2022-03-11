/**
 * 
 */
package uo.mp.util.file;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * A utility class to read/write text lines from/to a compressed text file
 * (.txt.gz)
 */
public class ZipFileUtil {

	public List<String> loadLines(String inFileName) throws FileNotFoundException {
		ArgumentChecks.isTrue(inFileName != null);
		List<String> res = new ArrayList<>();
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(new FileInputStream(inFileName))));

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

	public void saveToFile(List<String> lines, String outZippedFileName) throws FileNotFoundException {
		try {
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outZippedFileName))));
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

