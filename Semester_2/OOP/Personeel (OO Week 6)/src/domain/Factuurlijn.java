package domain;

public class Factuurlijn {
    String artikelnaam;
    int aantal;
    double eenheidsprijs;

    public Factuurlijn(String artikelnaam, int aantal, double eenheidsprijs) {
        this.artikelnaam = artikelnaam;
        this.aantal = aantal;
        this.eenheidsprijs = eenheidsprijs;
    }

    public double getTotaalprijs(){
        return eenheidsprijs*aantal;
    }
}
