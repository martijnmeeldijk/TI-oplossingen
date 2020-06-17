package domain;

import java.time.LocalDate;

public class Snoepgoed extends Geschenk {
    String naam;
    LocalDate vervaldatum;


    public Snoepgoed( String naam, LocalDate vervaldatum, double prijs) {
        super(prijs);
        this.naam = naam;
        this.vervaldatum = vervaldatum;
    }
    public boolean isVervallen(){
        return vervaldatum.isBefore(LocalDate.now());
    }

    public LocalDate geefVervaldatum() {
        return vervaldatum;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() == this.getClass()){
            Snoepgoed t = (Snoepgoed) o;
            return t.getNaam().equals(this.getNaam());
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Naam: " + naam + "Vervaldatum: " + vervaldatum.toString() + super.toString();
    }
}
