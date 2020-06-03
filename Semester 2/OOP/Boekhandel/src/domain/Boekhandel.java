package domain;

import java.util.ArrayList;

public class Boekhandel {

    ArrayList<Product> lijst = new ArrayList<>();

    public Boekhandel(){

    }
    public void addProduct(Product iets){
        lijst.add(iets);
    }
    public String geefVoorraadInString(){
        String alles = "";
        for(Product p : lijst){
            alles += p.naarString() + "\n";
        }
        return alles;
    }
    public String geefProductVoorraad(Product p){

        String uitvoer = "";
        for(Product t : lijst){
            if(t == p){
                uitvoer += t.naarString();
            }
        }
        return uitvoer;
    }

    public String printWeekbladen(int uitgifte){
        String uitvoer = "";
        for(Product t : lijst){
            if(super.equals(t) && t instanceof Tijdschrift){
                Tijdschrift p = (Tijdschrift)t;
                if(p.getWeek() == uitgifte) {
                    uitvoer +=  p.naarString() + "\n";
                }
            }
        }
        return uitvoer;
    }
    public void verkoop(Product p, int aantal){
        p.verkocht(aantal);
    }
    public void voegToeAanVoorraad(Product p, int aantal){
        if(aantal == 0){
            throw new IllegalArgumentException("Dommie, je kan niet '0' producten toevoegen aan de voorraad");
        }
        if(aantal < 0){
            throw new IllegalArgumentException("Je kan geen negatief aantal bestellen!!!");
        }
        p.setVoorraad(p.getVoorraad() + aantal);
    }





}
