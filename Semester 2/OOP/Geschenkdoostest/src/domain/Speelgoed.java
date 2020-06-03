package domain;

public class Speelgoed extends Geschenk {
    String naam;
    String firmanaam;

    public Speelgoed(String naam, String firmanaam, double prijs) {
        super(prijs);
        this.naam = naam;
        this.firmanaam = firmanaam;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() == this.getClass()){
            Speelgoed t = (Speelgoed) o;
            return t.getNaam().equals(this.getNaam());
        }
        else return false;
    }

    @Override
    public String toString() {
        return "naam: " + naam + "firmanaam: " + firmanaam + super.toString();
    }
}
