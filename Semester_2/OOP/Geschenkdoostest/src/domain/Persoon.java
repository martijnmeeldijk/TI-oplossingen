package domain;

import java.time.LocalDate;
import java.util.Objects;

public class Persoon {
    private String  naam, voornaam;
    private LocalDate geboorteDatum;

    public Persoon(String naam, String voornaam, LocalDate geboorteDatum) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboorteDatum = geboorteDatum;
    }

    public int getLeeftijd(){
        if(this.geboorteDatum == null)
            throw new DomainException("Geboortedatum niet gekend, leeftijd kan niet berekend worden");
        int aantalJaren = LocalDate.now().getYear() - this.geboorteDatum.getYear();
        if(aantalJaren<0)
            throw new DomainException("Geboortedatum na huidige datum, leeftijd kan niet berekend worden");
        if (this.geboorteDatum.plusYears(aantalJaren).isAfter(LocalDate.now())) aantalJaren--;
        return  aantalJaren;
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) return false;
        Persoon persoon = (Persoon) o;
        return Objects.equals(naam, persoon.naam) &&
                Objects.equals(voornaam, persoon.voornaam) &&
                Objects.equals(geboorteDatum, persoon.geboorteDatum);
    }

    @Override
    public String toString() {
        return naam + " " + voornaam + " (geboorteDatum: " + geboorteDatum + ")";
    }
}