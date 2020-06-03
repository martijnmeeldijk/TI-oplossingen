package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import domain.TweeSteden;

public class Databank {
	private String fileName;

	private Map<Object, Object> mijnmap = new HashMap<>();
 	private Object afstanden;

	public Databank() {
		this("google_afstanden.txt");
	}

	public Databank(String filename) {
		setFileName(filename);
		loadData();
	}

	private void loadData() {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(getFileName()));
			while (scanner.hasNextLine()) {
				Scanner lijnScanner = new Scanner(scanner.nextLine());

				// TODO Read the information from a line and add it to your
				// afstanden

				String stadVan = null;
				String stadNaar = null;

				double km = 0;

				this.voegToe(new TweeSteden(stadVan, stadNaar), km);
				lijnScanner.close();
			}
		} catch (FileNotFoundException e) {
			throw new DbException(e.getMessage(), e);
		} finally {
			if(scanner != null){
				scanner.close();
			}
		}
	}

	private void voegToe(TweeSteden afstand, double km) {
		if (afstand == null
		// Add a distance only if no duplicate exists already
		) {
			throw new IllegalArgumentException();
		}
		// Add the distance to afstanden
	}

	private String getFileName() {
		return fileName;
	}

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Map<TweeSteden, Double> getAfstanden() {
		// TODO
		return null;
	}
}
