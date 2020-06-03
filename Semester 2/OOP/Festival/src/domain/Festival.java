package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Festival {
    String naam;
    LocalDate datum;
    Map<Persoon, List<Optreden>> reservaties;
    Set<Optreden> optredens = new TreeSet<>(new ComparatorByPrijsArtiest());
    Set<Werknemer> werknemers;
    ComparatorByPrijsArtiest cmp = new ComparatorByPrijsArtiest();

    public Festival(String naam, LocalDate datum) {
        this.naam = naam;
        this.datum = datum;
        reservaties = new HashMap<>();
        werknemers = new HashSet<>();

    }

    public void voegOptredenToe(Artiest a, LocalTime l){
        Optreden o = new Optreden(a, l);
        optredens.add(o);
    }
    public void voegOptredenToe(Optreden o){
        optredens.add(o);
    }
    private void voegNieuweBezoekerToe(Persoon p){
        List<Optreden> l = new ArrayList<Optreden>();
        reservaties.put(p, l);

    }
    public void voegWerknemerToe(Werknemer w){
        werknemers.add(w);
    }

    public void voegWerknemerToe(String naam, String voornaam, LocalDate geboorte, String rijksreg, boolean isVrijwilliger){
        if (isVrijwilliger){
            VrijwilligeWerknemer v = new VrijwilligeWerknemer(naam, voornaam, geboorte, rijksreg, 0, 0);
        }
        else{
            Werknemer w = new Werknemer(naam, voornaam, geboorte, rijksreg, 0);
        }
    }
    public void voegReservatieToe(Persoon p, Optreden o){

        if(reservaties.containsKey(p)){
            reservaties.get(p).add(o);
        }
        else{
            reservaties.put(p, new ArrayList<>(List.of(o)));
        }

    }

    public String overzichtReservatiesVoorGegevenPersoon(Persoon p){
        String output = p.toString() + "heeft volgende optredens gereserveerd:";
        for(Optreden o : reservaties.get(p)){
            output += " " + o.toString();
        }
        return output;
    }
    public double inkomprijsVoorGegevenPersoon(Persoon p){

        List<Optreden> optredens = reservaties.get(p);
        double prijs = 0;
        for(Optreden o : optredens){
            prijs += o.getTicketPrijs();
        }
        return prijs;
    }
    public String printLijstTeCompenserenWerknemers(){
        String output = "";
        for(Werknemer w : werknemers){
            if(w instanceof TeCompenseren || w instanceof TeBetalen){
                output += " " + w.toString();
            }
        }
        return output;
    }
    public String printOptredens(){
        String output = "";
        for(Optreden o : optredens){
            output += " " + o.toString();
        }
        return output;
    }



}
