package domain;

public abstract class Food extends Product {

    public Food(String naam, double prijs, int aantal){
        super(naam, prijs, aantal);
    }

    @Override
    public boolean equals(Object o){
        if(this.getClass() == o.getClass() && this.naam != null){
            Food p = (Food) o;
            if(p.naam == this.naam) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString() + " Categorie: " + "Food";
    }

    public abstract double teBetalenPrijs();
}
