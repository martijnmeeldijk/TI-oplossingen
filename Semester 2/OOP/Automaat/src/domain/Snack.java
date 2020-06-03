package domain;

public class Snack extends Food {
    public Snack(String naam, double prijs, int aantal){
        super(naam, prijs/2, aantal);
    }

    @Override
    public boolean equals(Object o){
        if(this.getClass() == o.getClass() && this.naam != null){
            Snack p = (Snack) o;
            if(p.naam == this.naam) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString() + ": Snack";
    }

    @Override
    public double teBetalenPrijs() {
        return prijs*0.75;
    }
}
