package dome.entities;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MediaLibrary {
	private List<Cd> cds;
	private List<Dvd> dvds;

	public MediaLibrary() {
		cds = new ArrayList<Cd>();
		dvds = new ArrayList<Dvd>();
	}

	public void add(Cd theCD) {
		cds.add(theCD);
	}

	public void add(Dvd theDVD) {
		dvds.add(theDVD);
	}

	public void list(PrintStream out) {
		for (Cd cd : cds) {
			cd.print(out);
			out.println();
		}
		for (Dvd dvd : dvds) {
			dvd.print(out);
			out.println();
		}
	}

}
