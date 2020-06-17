package domain;

import java.time.LocalDate;

public class Werknemer extends Persoon {
    String rijksregisternr;
    int aantalGewerkteUren;

    public Werknemer(String naam, String voornaam, LocalDate geboortedatum, String rijksregisternr, int aantalGewerkteUren) {
        super(naam, voornaam, geboortedatum);
        if(isGeldigRijksRegNr(rijksregisternr)) {
            this.rijksregisternr = rijksregisternr;
            this.aantalGewerkteUren = aantalGewerkteUren;
        }
        else{
            throw new IllegalArgumentException("Rijksregisternummer is ongeldig");
        }
    }

    private boolean isGeldigRijksRegNr(String t){
        // XXXXXX-XXX-XX
        return t.length() == 13 && t.charAt(6) == ('-') && t.charAt(10) == ('-');
    }

    public String getRijksregisternr() {
        return rijksregisternr;
    }

    public int getAantalGewerkteUren() {
        return aantalGewerkteUren;
    }
    public void pasGewerkteUrenAan(int aantalGewerkteUren){
        this.aantalGewerkteUren = aantalGewerkteUren;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + " " + rijksregisternr + " " + aantalGewerkteUren;
    }
}
