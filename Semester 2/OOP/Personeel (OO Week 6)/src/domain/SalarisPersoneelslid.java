package domain;

public class SalarisPersoneelslid extends Personeelslid {

    double loon;
    public SalarisPersoneelslid(int nummer, String naam, int maand, int jaar, double loon) {
        super(nummer, naam, maand, jaar);
        this.loon = loon;
    }


    @Override
    public double getBedrag(int maand, int jaar) {
        return loon;
    }
}
