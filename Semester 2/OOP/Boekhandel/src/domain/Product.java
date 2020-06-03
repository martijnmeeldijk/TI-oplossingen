package domain;

public class Product {

    protected String titel;
    protected double prijs;
    protected int voorraad;

    public Product(String titel, double prijs){
        this.prijs = prijs;
        this.titel = titel;
    }


    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public int getVoorraad() {
        return voorraad;
    }
    public void verkocht(int i){
        if(voorraad - i < 0){
            throw new IllegalArgumentException("Voorraad is leeg");
        }
        voorraad -= i;

    }

    public String naarString(){
        return "Titel: " + titel + " | Prijs: €" + prijs + " | Er zijn " + voorraad + " stuks in voorraad | ";
    }

    public String getTitel() {
        return titel;
    }

    public double getPrijs() {
        return prijs;
    }

    @Override
    public boolean equals(Object b){
        if (b instanceof Product) {
            Product p = (Product) b;
            return p.getTitel() == this.titel;
        }
        else return false;
    }
}
