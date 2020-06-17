package domain;

public class Boek extends Geschenk implements HeeftMinimumLeeftijd {
    String titel;
    String auteur;
    int aantalPaginas;


    public Boek(String titel, String auteur, int aantalPaginas, double prijs) {
        super(prijs);

        this.titel = titel;
        this.auteur = auteur;
        if(aantalPaginas < 1) throw new DomainException("Ongeldig aantal paginas");
        this.aantalPaginas = aantalPaginas;

    }

    public String getTitel() {
        return titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAantalPaginas() {
        return aantalPaginas;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() == this.getClass()){
            Boek t = (Boek) o;
            return t.getAuteur().equals(this.getAuteur()) && t.getTitel().equals(this.getTitel());
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Titel: " + titel + "Auteur: " + auteur + "Aantal Paginas: " + aantalPaginas + super.toString();
    }

    @Override
    public int geefMinimumLeeftijd() {

        if(aantalPaginas < 10) return 0;
        else{
            return 8 + (aantalPaginas - 10)/50;
        }

    }
}
