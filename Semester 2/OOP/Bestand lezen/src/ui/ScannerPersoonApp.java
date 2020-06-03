package ui;

import domain.Persoon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ScannerPersoonApp {
    public static void main (String[] args) {
        ArrayList<Persoon> personen = new ArrayList<>(); 		// alle info van bestand komt hier in terecht
        File personenFile = new File("Personen.txt");
        try {
            Scanner scannerFile = new Scanner(personenFile);  		// scanner voor File
            while (scannerFile.hasNextLine()) {  				// voor elke lijn van het bestand
                Scanner scannerLijn = new Scanner(scannerFile.nextLine());  	// scanner voor lijn
                scannerLijn.useDelimiter("/");  				// scheidingstekens van verschillende delen in de huidige lijn
                String voornaam = scannerLijn.next(); 			// eerste deel huidige lijn tot aan /
                String naam = scannerLijn.next(); 				// tweede deel huidige lijn tot aan /
                Persoon persoon = new Persoon(naam, voornaam);
                personen.add(persoon);
            }
        }  catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("Fout bij het inlezen", ex);
        }

        for(Persoon p : personen){
            System.out.println(p.getNaam() + " " + p.getVoornaam());
        }


    }

}
