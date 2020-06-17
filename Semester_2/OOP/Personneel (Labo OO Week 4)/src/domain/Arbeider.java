package domain;

public class Arbeider extends Personeelslid {
    private double uurloon;

    public Arbeider(String code, String naam, double uurloon){
        super(code, naam);
        this.uurloon = uurloon;
    }
    public double berekenLoon(){
        if(super.getUren() < 38) return super.getUren()*uurloon;
        else{
            return 38*uurloon; // + nog iets
        }
    }
}
