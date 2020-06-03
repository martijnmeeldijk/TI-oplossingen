package domain;

import java.util.ArrayList;

public class Artiest implements TeBetalen {
    String naam;
    double prijs;

    public Artiest(String naam, double prijs) {
        if(prijs < 0) throw new IllegalArgumentException("Prijs mag niet negatief te zijn");
        this.naam = naam;
        this.prijs = prijs;
    }

    @Override
    public double getLoon() {
        return prijs;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Artiest){
            Artiest a = (Artiest) obj;
            return a.getNaam() == this.getNaam();
        }
        return false;
    }

    @Override
    public String toString() {
        return naam + "Artiest Prijs: " + getLoon();
    }
}
