package domain;

public abstract class Product {

    protected String naam;
    protected double prijs;
    protected int aantal;

    public Product(String naam, double prijs, int aantal){
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;

    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public abstract double teBetalenPrijs();

    @Override
    public boolean equals(Object o){
        if(this.getClass() == o.getClass() && this.naam != null){
            Product p = (Product) o;
            if(p.naam == this.naam) return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return "Naam: " + this.naam + "\t\t| Prijs: €" + this.teBetalenPrijs() + "\t| Aantal:" + this.aantal + "\t| ";
    }
}
