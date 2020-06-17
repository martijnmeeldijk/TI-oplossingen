package domain;

public class NonFood extends Product {

    boolean toegelatenMinderjarig;

    public NonFood(String naam, double prijs, int aantal, boolean toegelatenMinderjarig){
        super(naam, prijs, aantal);
        this.toegelatenMinderjarig = toegelatenMinderjarig;
    }

    @Override
    public boolean equals(Object o){
        if(this.getClass() == o.getClass() && this.naam != null){
            NonFood p = (NonFood) o;
            if(p.naam == this.naam) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString() + " Categorie: " + "NonFood" + (toegelatenMinderjarig? "": " \t| Niet toegelaten voor -16");
    }

    @Override
    public double teBetalenPrijs() {
        return toegelatenMinderjarig? prijs : prijs + prijs*0.2;
    }
}
