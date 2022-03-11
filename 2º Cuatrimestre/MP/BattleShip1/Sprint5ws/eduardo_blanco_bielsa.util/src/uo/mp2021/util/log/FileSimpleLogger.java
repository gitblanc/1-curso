/**
 * 
 */
package uo.mp2021.util.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class FileSimpleLogger implements SimpleLogger {

	public static final boolean FOR_APPENDING = true;
	private String name;

	public FileSimpleLogger(String name) {
		ArgumentChecks.isTrue(name != null);
		ArgumentChecks.isTrue(!name.isBlank());
		this.name = name;
	}
	
	@Override
	public void log(Exception ex) {
		Date d = new Date();
		String date = new SimpleDateFormat("dd/MM/yy").format(d);
		String time = new SimpleDateFormat("HH:mm:ss").format(d);
		
		String cadfinal = "[" + date + "——" + time + "]: " + ex.getMessage();

		writeLines(this.name, cadfinal);

	}

	public void writeLines(String outFileName, String line) {
		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName, FOR_APPENDING));
			try {
				out.write(line);
				out.newLine();

			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error en escritura de datos");
		}
	}

	public String getName() {
		return name;
	}

}
