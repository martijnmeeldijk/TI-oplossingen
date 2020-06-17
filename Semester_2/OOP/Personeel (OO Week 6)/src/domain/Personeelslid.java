package domain;

public abstract class Personeelslid implements IsBetaalbaar {
    String naam;
    int nummer;
    int maand;
    int jaar;



    public Personeelslid(int nummer, String naam, int maand, int jaar) {
        this.naam = naam;
        this.nummer = nummer;
        this.maand = maand;
        this.jaar = jaar;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }
}
