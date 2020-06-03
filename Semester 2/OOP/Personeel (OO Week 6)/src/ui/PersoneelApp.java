package ui;

import domain.*;

import java.util.ArrayList;
import java.util.List;

public class PersoneelApp {
    public static void main(String[] args){
        Personeelslid p1= new SalarisPersoneelslid(1,"Jansen", 4,2014,2000.00);
        Personeelslid p2= new SalarisPersoneelslid(2,"Fransen", 2,2015,2087.00);
        Personeelslid p3= new SalarisPersoneelslid(3,"Jansen", 4,2016,1977.50);
        Factuur f1 =new Factuur (201601,2,2016,new Factuurlijn("a1",10,102.34));
        Factuur f2 =new Factuur(201602,2,2016,
                new Factuurlijn("a1",102,102.34), new Factuurlijn("a12",21,200.00));
        Factuur f3 = new Factuur (201603,4,2016,
                new Factuurlijn("a7",85,1046.50), new Factuurlijn("a23",8,100.34));

        Bedrijf bedrijf = new Bedrijf();

        bedrijf.voegToe( f1, f2, f3);
        bedrijf.voegToe(p1, p2, p3);

        System.out.println(bedrijf.kostenVanMaand(2, 2016));
    }


}
