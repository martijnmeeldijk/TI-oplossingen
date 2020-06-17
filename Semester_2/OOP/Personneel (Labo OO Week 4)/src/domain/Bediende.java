package domain;

public class Bediende extends Personeelslid {

    double maandloon;

    public Bediende(String code, String naam, double maandloon){
        super(code, naam);
        this.maandloon = maandloon;
    }

    public double berekenLoon(){
        return maandloon;
    }
}
