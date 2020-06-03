package ui;

import domain.Arbeider;
import domain.Bediende;
import domain.Personeel;

public class PersoneelUI {
    public static void main(String[] args) {
        Personeel personeel = new Personeel();
        try{
            personeel.voegToe(new Bediende("102","Jan", 2000));
            personeel.werkt("102", 30);
            personeel.voegToe(new Arbeider("222","An", 40));
            personeel.werkt("222", 30);
            personeel.voegToe(new Bediende("104","Piet", 2200));
            personeel.werkt("104", 36);
            personeel.voegToe(new Arbeider("226","Bert", 44));
            personeel.werkt("226", 40);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(personeel.betaal());
    //to implement:
    //verhoog het uurloon van alle arbeiders met 5 procent
    //voorzie hiervoor de nodige extra methodes
    }
}