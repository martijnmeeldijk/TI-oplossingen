package domain;

public class Drank extends Food {



    public Drank(String naam, double prijs, int aantal){
        super(naam, prijs, aantal);
    }

    @Override
    public boolean equals(Object o){
        if(this.getClass() == o.getClass() && this.naam != null){
            Drank p = (Drank) o;
            if(p.naam == this.naam) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString() + ": Drank";
    }

    @Override
    public double teBetalenPrijs() {
        return prijs/2 ;
    }
}
