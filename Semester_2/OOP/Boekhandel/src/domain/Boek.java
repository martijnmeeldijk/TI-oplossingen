package domain;

public class Boek extends Product {

    private int uitgave;

    public Boek(String titel, double prijs, int uitgave){
        super(titel, prijs);
        this.uitgave = uitgave;
    }

    @Override
    public String naarString() {
        return "| Uitgave: " + uitgave+ " | " + super.naarString();
    }

    public int getUitgave() {
        return uitgave;
    }

    @Override
    public boolean equals(Object b){
        if (super.equals(b) && b instanceof Boek) {
        Boek p = (Boek) b;
        return p.getUitgave() == this.uitgave && super.equals(p);
    }
        else return false;    }
}
