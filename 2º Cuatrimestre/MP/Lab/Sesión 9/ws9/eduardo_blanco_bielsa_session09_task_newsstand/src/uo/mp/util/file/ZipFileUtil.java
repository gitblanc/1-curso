package uo.mp.util.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import uo.mp.newsstand.service.exception.NotYetImplementedException;

/**
 * A utility class to read/write text lines from/to a compressed text file
 * (.txt.gz)
 */
public class ZipFileUtil {

	public List<String> readLines(String inFileName) {
		List<String> res = new ArrayList<>();
		try {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream(inFileName))));
		
			try {
				while (in.ready()) {// mientras haya l?neas
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

	public void writeLines(String outZippedFileName, List<String> lines) {
		throw new NotYetImplementedException();
	}

}
