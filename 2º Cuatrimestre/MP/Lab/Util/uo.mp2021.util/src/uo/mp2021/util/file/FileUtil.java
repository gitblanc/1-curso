/**
 * 
 */
package uo.mp2021.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author blanc
 *
 */
public class FileUtil extends BaseFileUtil{

	@Override
	protected BufferedReader bufferReader1(String inFileName) throws FileNotFoundException {
		return new BufferedReader(new FileReader(inFileName));
	}

	@Override
	protected BufferedWriter bufferWriter1(String outFileName) throws FileNotFoundException, IOException {
		return new BufferedWriter(new FileWriter(outFileName));
	}
	
}
