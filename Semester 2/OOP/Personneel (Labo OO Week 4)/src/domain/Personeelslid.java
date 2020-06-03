package domain;

public abstract class Personeelslid {
    private String naam, code;
    private int uren;

    public Personeelslid(String code, String naam){
        this.naam = naam;
        this.code = code;
    }
    public abstract double berekenLoon();

    public boolean werk(int uren){
        this.uren += uren;
        return true;
    }

    @Override
    public boolean equals(Object o){
        return ((Personeelslid) o).getCode().equalsIgnoreCase(this.code);
    }


    public String getNaam() {
        return naam;
    }

    public String getCode() {
        return code;
    }

    public int getUren() {
        return uren;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUren(int uren) {
        this.uren = uren;
    }


}
