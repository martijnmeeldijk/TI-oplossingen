package db;

import domain.Opdracht;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*public Opdracht(int id, String vraag, String antwoord, boolean hoofdlettergevoelig, String hint, String categorie, String auteur)
        }*/

public class OpdrachtDatabank {
    ArrayList<Opdracht> opdrachten;

    public OpdrachtDatabank(String file)  {
        try {
            opdrachten = lees(file);
        }
        catch (FileNotFoundException f){throw new RuntimeException("File not found");}
    }

    public ArrayList<Opdracht> getOpdrachten() {
        return opdrachten;
    }

    public void voegToe(Opdracht o){
        opdrachten.add(o);
    }



    private ArrayList<Opdracht> lees(String file) throws FileNotFoundException{

        ArrayList<Opdracht> opdrachten = new ArrayList<>();        // alle info van bestand komt hier in terecht
        File opdrachtenFile = new File(file);

        Scanner scannerFile = new Scanner(opdrachtenFile);        // scanner voor File
        while (scannerFile.hasNextLine()) {                // voor elke lijn van het bestand
            Scanner scannerLijn = new Scanner(scannerFile.nextLine());    // scanner voor lijn
            scannerLijn.useDelimiter("\t");                // scheidingstekens van verschillende delen in de huidige lijn
            int id = Integer.parseInt(scannerLijn.next());
            String vraag = scannerLijn.next();
            String antwoord = scannerLijn.next();
            boolean hoofdlettergevoelig = scannerLijn.next().equalsIgnoreCase("true");
            String hint = scannerLijn.next() + "";
            String categorie = scannerLijn.next();
            String auteur = scannerLijn.next();

            Opdracht poep = new Opdracht(id, vraag, antwoord, hoofdlettergevoelig, hint, categorie, auteur);
            opdrachten.add(poep);
        }
        return opdrachten;
    }
}

