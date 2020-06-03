package model.domain;

public class Serie {

    String naam;
    int afleveringen;
    int duur;
    int rating;


    public Serie(String naam, int afleveringen, int duur, int rating){
        if(afleveringen < 1){
            throw new IllegalArgumentException("niet goed man");
        }
        this.naam = naam;
        this.afleveringen = afleveringen;
        this.duur = duur;
        this.rating = rating;
    }

    public String getNaam() {
        return naam;
    }

    public int getAfleveringen() {
        return afleveringen;
    }

    public int getDuur() {
        return duur;
    }

    public int getRating() {
        return rating;
    }
    @Override
    public String toString(){
        return naam + afleveringen + duur + rating;
    }
}
