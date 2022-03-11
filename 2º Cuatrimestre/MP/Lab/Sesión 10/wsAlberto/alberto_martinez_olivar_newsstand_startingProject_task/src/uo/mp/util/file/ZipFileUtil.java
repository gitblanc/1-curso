package uo.mp.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil extends File  {

	public BufferedReader bufferRead(String inFileName)  {
		try {
		return new BufferedReader(
								new InputStreamReader (
										new GZIPInputStream (
												new FileInputStream(inFileName))));
		} catch (IOException e) {
			throw new RuntimeException("Error al leer los datos");
		}
	}

	@Override
	protected BufferedWriter bufferWrite(String outFileName) {
		try {
			return new BufferedWriter(
					new OutputStreamWriter(
							new GZIPOutputStream(
									new FileOutputStream(outFileName))));
		} catch (IOException e) {
			throw new RuntimeException("Error al escribir el archivo");
		}
	}


	

}
