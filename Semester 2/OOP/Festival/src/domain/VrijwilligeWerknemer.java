package domain;

import java.time.LocalDate;

public class VrijwilligeWerknemer extends Werknemer implements TeCompenseren{

    int aantalBonnetjesPerUur;

    public VrijwilligeWerknemer(String naam, String voornaam, LocalDate geboortedatum, String rijksregisternr, int aantalGewerkteUren, int aantalBonnetjesPerUur) {
        super(naam, voornaam, geboortedatum, rijksregisternr, aantalGewerkteUren);
        this.aantalBonnetjesPerUur = aantalBonnetjesPerUur;
    }

    public int getAantalGratisBonnetjes(){
        return aantalBonnetjesPerUur*super.getAantalGewerkteUren();
    }

    @Override
    public String toString() {
        return super.toString() + " " + aantalBonnetjesPerUur;
    }


}
