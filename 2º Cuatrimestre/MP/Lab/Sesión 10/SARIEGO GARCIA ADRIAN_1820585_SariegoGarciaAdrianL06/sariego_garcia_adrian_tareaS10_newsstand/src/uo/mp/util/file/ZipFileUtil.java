package uo.mp.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil {

	public List<String> readLines(String inFileName) throws FileNotFoundException {
		List<String> res = new LinkedList<String>();

		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(
							new FileInputStream(inFileName))));

			String line;
			try {
				while ((line = in.readLine()) != null) {
					res.add(line);
				}
			} finally {
				in.close();
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return res;
	}

	public void writeLines(String outZippedFileName, List<String> lines) {
		try {
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(new GZIPOutputStream(
							new FileOutputStream(outZippedFileName))));

			try {
				for (String line : lines) {
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
