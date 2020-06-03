package domain;

import java.time.LocalDate;

public class TeBetalenWerknemer extends Werknemer implements TeBetalen{

    int prijsPerUur;

    public TeBetalenWerknemer(String naam, String voornaam, LocalDate geboortedatum, String rijksregisternr, int aantalGewerkteUren, int prijsPerUur) {
        super(naam, voornaam, geboortedatum, rijksregisternr, aantalGewerkteUren);
        this.prijsPerUur = prijsPerUur;
    }

    public double getLoon(){
        return prijsPerUur*super.getAantalGewerkteUren();
    }

    @Override
    public String toString() {
        return super.toString() + " Loon: " + getLoon() + " euro";
    }
}
