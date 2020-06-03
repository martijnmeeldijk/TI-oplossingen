package domain;

public class SpeelgoedMetMinimumLeeftijd extends Speelgoed implements HeeftMinimumLeeftijd {
    int minimumleeftijd;

    public SpeelgoedMetMinimumLeeftijd(String naam, String firmanaam, double prijs, int minimumleeftijd) {
        super(naam, firmanaam, prijs);
        this.minimumleeftijd = minimumleeftijd;
    }

    public String getNaam(){
        return super.getNaam();
    }


    @Override
    public String toString() {
        return "Minimumleeftijd: " + minimumleeftijd + super.toString();
    }

    @Override
    public int geefMinimumLeeftijd() {
        return minimumleeftijd;
    }
    @Override
    public boolean equals(Object o){
        if(o.getClass() == this.getClass()){
            SpeelgoedMetMinimumLeeftijd t = (SpeelgoedMetMinimumLeeftijd) o;
            return t.getNaam().equals(this.getNaam());
        }
        else return false;
    }
}
