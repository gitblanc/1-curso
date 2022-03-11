package uo.mp.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public abstract class File {

	

	public List<String> readLines(String inFileName) throws FileNotFoundException {
		List<String> res = new LinkedList<>();
		BufferedReader in = bufferRead(inFileName);;
		try {
		try {
			while(in.ready()) {
				String line = in.readLine();
				res.add(line);
			}
		
		} finally {
			in.close();
		}
		}catch(IOException e) {
			throw new RuntimeException("Error en lectura de datos");
		}
		
		return res;
	}

	public void writeLines(String outFileName, List<String> lines) throws FileNotFoundException {
		try {
			BufferedWriter out = bufferWrite(outFileName);
			try {
				for (String line: lines){
					out.write(line);
					out.newLine();
				}
			} finally {
				out.close();
			}
			} catch (FileNotFoundException e) {
				throw new FileNotFoundException();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			}
	protected abstract BufferedWriter bufferWrite(String outFileName);
	
	
	protected abstract BufferedReader bufferRead(String inFileName) throws FileNotFoundException;
}