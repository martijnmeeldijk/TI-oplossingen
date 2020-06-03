package domain;

import java.time.LocalTime;
import java.util.ArrayList;

public class Machine {
    ArrayList<Product> productlijst = new ArrayList<>();
    LocalTime laatsteAanvulling;

    public Machine(){

    }

    public void voegProducttoe(Product p){
        if(p.getNaam() != null && p.getAantal() != 0 && p.getPrijs() != 0){
            productlijst.add(p);
        }
        else throw new IllegalArgumentException("3RR0R");
    }
    public void voegProductlijstToe(ArrayList<Product> p){
        for(Product t : p) {
            voegProducttoe(t);
        }

    }
    public Product isProductAanwezig(Product p){
        for(Product i : productlijst){
            if(i.getClass() == p.getClass() && i.getNaam() == p.getNaam()) return p;
        }
        return null;
    }
    public void vulAan(Product p, int aantal){
        if(isProductAanwezig(p) != null){
            isProductAanwezig(p).setAantal(aantal);
            laatsteAanvulling = LocalTime.now();
        }
    }
    public String geefLaatsteAanvulling(){
        if(laatsteAanvulling != null){
            return laatsteAanvulling.toString();
        }
        else return "De machine is nog nooit aangevuld. \nDANKU SOSSEN";
    }

    public String geefProductenString(){
        String result = "Beschikbare Producten: ";
        for(Product p : productlijst){
            result += "\n" + p.toString();
        }
        return result;
    }
    public double berekenTotaalPrijs(){
        double totaal = 0;
        for(Product p : productlijst){
            totaal += p.getPrijs();
        }
        return totaal;
    }

    public String geefProductenMinderDan(double prijs) {
        String antwoord = "";
        for (Product p : productlijst) {
            if (p.teBetalenPrijs() < prijs) {
                antwoord += p.toString() + "\n";
            }
        }
        return antwoord;
    }





}
