package domain;

import java.time.LocalDate;

import static java.util.Objects.hash;

public class Persoon {
    String naam;
    String voornaam;
    LocalDate geboortedatum;

    public Persoon(String naam, String voornaam, LocalDate geboortedatum) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboortedatum = geboortedatum;
    }

    @Override
    public String toString() {
        return naam + " " + voornaam + " " + geboortedatum;
    }

    @Override
    public int hashCode() {
        return hash(naam, voornaam, geboortedatum);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Persoon){
            Persoon p = (Persoon) obj;
            return p.naam == this.naam && p.voornaam == this.voornaam && p. geboortedatum == this.geboortedatum;

        }
        return false;
    }
}
