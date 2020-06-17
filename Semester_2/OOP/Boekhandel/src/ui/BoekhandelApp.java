package ui;

import domain.Boek;
import domain.Boekhandel;
import domain.Cd;
import domain.Tijdschrift;

public class BoekhandelApp {

    public static void main(String[] args){

        Boekhandel sexShop = new Boekhandel();
        Boek piwi = new Boek("Anuskanker", 100, 69);
        Cd oorkanker = new Cd("Oorkanker", 2,"U2");
        Tijdschrift playboy = new Tijdschrift("Lekkere babes", 4,4);
        Tijdschrift penthouse = new Tijdschrift("Natte katjes", 5,4);
        Tijdschrift xnxx = new Tijdschrift("Milf gets Pounded", 10,4);
        Tijdschrift RedTube = new Tijdschrift("RedTube Magazine", 2,4);
        Tijdschrift Brazzers = new Tijdschrift("Brazzers Magazine", 2,7);
        Cd leukeMuziek = new Cd("Gezellig",5,"Justin Bieber");

        sexShop.addProduct(piwi);
        sexShop.addProduct(oorkanker);
        sexShop.addProduct(playboy);
        sexShop.addProduct(penthouse);
        sexShop.addProduct(xnxx);
        sexShop.addProduct(RedTube);
        sexShop.addProduct(Brazzers);
        sexShop.addProduct(leukeMuziek);


        Cd tester = new Cd("Gezellig",5,"Justin Bieber");
        System.out.println("is gezellig van justin bieber gelijk aan gezellig van justin bieber? " + leukeMuziek.equals(tester));
        System.out.println("is gezellig van justin bieber gelijk aan Milf gets pounded week 4? " +leukeMuziek.equals(xnxx));


        sexShop.voegToeAanVoorraad(xnxx, 100);

        sexShop.verkoop(xnxx,5);

        leukeMuziek.setVoorraad(11);
        System.out.println(sexShop.geefProductVoorraad(leukeMuziek));







    }
}
