package domain;

public class Cd extends Product {

    private String artiest;


    public Cd(String titel, double prijs, String artiest){
        super(titel, prijs);
        this.artiest = artiest;
    }

    @Override
    public String naarString(){
        return "| Artiest: " + artiest + " | " + super.naarString();

    }

    public String getArtiest() {
        return artiest;
    }

    @Override
    public boolean equals(Object b){
        if (b instanceof Cd) {
            Cd p = (Cd) b;
            return p.getArtiest() == this.artiest && super.equals(p);
        }
        else return false;
    }
}
