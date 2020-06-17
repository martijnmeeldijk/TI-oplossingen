package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Geschenkdoos {
    Persoon ontvanger;
    Persoon zender;
    ArrayList<Geschenk> geschenken = new ArrayList<>();


    public Geschenkdoos(Persoon ontvanger, Persoon zender, Geschenk geschenk) {
        this.ontvanger = ontvanger;
        this.zender = zender;
        voegGeschenkToe(geschenk);
    }
    public void voegGeschenkToe(Geschenk g){
        if(!controleerVervalDatum(g) && controleerLeeftijd(g)) {
            geschenken.add(g);
        }
        else throw new DomainException("De vervaldatum of de benodigde leeftijd zijn niet in orde!!");
    }
    private int geefLeeftijd(Geschenk g){
        if(g instanceof HeeftMinimumLeeftijd){
            return ((HeeftMinimumLeeftijd) g).geefMinimumLeeftijd();
        }
        else return 0;
    }
    private boolean controleerLeeftijd(Geschenk g){
        if(geefLeeftijd(g) > ontvanger.getLeeftijd()){
            return false;
        }
        else return true;
    }
    private static LocalDate geefVervaldatum(Geschenk g){
        if(g instanceof HeeftVervaldatum){
            return ((HeeftVervaldatum) g).geefVervaldatum();
        }
        else throw new DomainException("Vervaldatum bestaat niet");
    }
    private static boolean controleerVervalDatum(Geschenk g){
        try{
            LocalDate datum = geefVervaldatum(g);
            return datum.isBefore(LocalDate.now());
        }
        catch (DomainException e){
            return false;
        }
        // false betekent niet vervallen
        // true betekent vervallen
    }
    public List<HeeftVervaldatum> geefAlleVervallenGeschenken(){
        List<HeeftVervaldatum> vervallen = new ArrayList<>();

        for(Geschenk g : geschenken){
            if(g instanceof HeeftVervaldatum){
                if(controleerVervalDatum(g)){
                    vervallen.add((HeeftVervaldatum) g);
                }
            }
        }
        return vervallen;
    }
    public double berekenPrijs(){
        double prijs = 0;
        for(Geschenk g : geschenken){
            prijs += g.getPrijs();
        }
        return prijs;
    }

    @Override
    public String toString() {
        return "Ontvanger: " + ontvanger + "Zender: " + zender + "Geschenken: " + geschenken.toString();
    }
}
