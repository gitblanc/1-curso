/**
 * 
 */
package uo.mp2021.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author blanc
 *
 */
public class ZipFileUtil extends BaseFileUtil{

	@Override
	protected BufferedReader bufferReader1(String inFileName) throws FileNotFoundException {
		try {
            return new BufferedReader(new InputStreamReader(
                    new GZIPInputStream(new FileInputStream(inFileName))));
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	protected BufferedWriter bufferWriter1(String outFileName) throws FileNotFoundException, IOException {
		return new BufferedWriter(
                new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outFileName))));
	}

}
