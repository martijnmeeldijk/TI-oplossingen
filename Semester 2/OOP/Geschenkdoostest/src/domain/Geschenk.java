package domain;

public abstract class Geschenk {
    double prijs;

    public Geschenk(double prijs) {
        this.prijs = prijs;
    }

    public double getPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        return "Prijs: " + prijs;
    }

    @Override
    public boolean equals(Object o){
        return this == o;
    }

}
