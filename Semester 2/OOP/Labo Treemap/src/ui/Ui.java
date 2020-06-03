package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import domain.CategoriesPerLeeftijd;

public class Ui {

	public static void main(String[] args) {
		CategoriesPerLeeftijd categories = new CategoriesPerLeeftijd(10);
		File namen = new File("invoer.txt");
		try {
			Scanner scannerFile = new Scanner(namen);
			while (scannerFile.hasNextLine()) {
				Scanner scannerLijn = new Scanner(scannerFile.nextLine());
				scannerLijn.useDelimiter(", ");

				String naam = scannerLijn.next();
				int leeftijd = scannerLijn.nextInt();
				categories.voegToe(leeftijd, naam);
				scannerLijn.close();
			}
			scannerFile.close();
		} catch (FileNotFoundException ex) {
			//TODO !!!
		}

		try {
			File uit = new File("uitvoer.txt");
			PrintWriter writer = new PrintWriter(uit);
			writer.println(categories.toString());
			writer.close();
		} catch (FileNotFoundException ex) {
			//TODO !!!
		}
        System.out.println("gedaan");

	}
}
