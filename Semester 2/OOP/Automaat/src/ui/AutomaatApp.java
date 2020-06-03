package ui;

import domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AutomaatApp {
    public static void main(String[] args){
        ArrayList<Product> lijst = new ArrayList<>();
        Snack snickers = new Snack("Snickers", 2, 5);
        Snack mars = new Snack("Mars", 1.5,10 );
        Drank cola = new Drank("Coca-Cola", 2.5, 3);
        Drank pizzaSap = new Drank("Pizza Sap", 10,2);
        NonFood tampon = new NonFood("XXL Tampon", 3,4, true);
        NonFood grasmaaier = new NonFood("Grasmaaier 2000", 1, 200,false);

        lijst.addAll(Arrays.asList(snickers, mars, cola, pizzaSap, tampon, grasmaaier));

        Machine BigBoy = new Machine();
        BigBoy.voegProductlijstToe(lijst);

        //System.out.println(BigBoy.geefProductenString());
        System.out.print(BigBoy.geefProductenMinderDan(10));


    }
}
