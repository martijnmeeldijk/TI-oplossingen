package ui;

import domain.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class FestivalApp {
    public static void main(String[] args) {


        Festival werchter = new Festival("Rock Werchter 2011", LocalDate.of(2011, 06, 30));

        Artiest willy = new Artiest("Willy Somers", 2000);
        Artiest xink = new Artiest("X!NK", 1000000);
        Artiest vijandvechters = new Artiest("De Vijand Vechters", 20);
        Artiest pinkguy = new Artiest("Pink Guy", 2124);

        Optreden willyLive = new Optreden(willy, LocalTime.of(22, 00), 20);
        Optreden vijanden = new Optreden(vijandvechters, LocalTime.of(10, 00), 1);
        Optreden xonk = new Optreden(xink, LocalTime.of(23, 23), 1234);
        Optreden pink = new Optreden(pinkguy, LocalTime.of(12,12));

        Persoon greetje = new Persoon("Jongen", "Greetje", LocalDate.of(1945, 12,12));
        Persoon karen = new Persoon("Baerts", "Karen", LocalDate.of(1980, 10, 10));

        Werknemer bob = new TeBetalenWerknemer("Stommie", "Bob", LocalDate.of(1980, 10, 10), "432112-123-23", 20, 12);


        werchter.voegOptredenToe(willyLive);
        werchter.voegOptredenToe(vijanden);
        werchter.voegOptredenToe(xonk);
        werchter.voegOptredenToe(pink);

        werchter.voegWerknemerToe(bob);
        werchter.voegReservatieToe(greetje, vijanden);
        werchter.voegReservatieToe(karen, willyLive);
        werchter.voegReservatieToe(karen, xonk);

        System.out.println(werchter.overzichtReservatiesVoorGegevenPersoon(karen));
        System.out.println(werchter.inkomprijsVoorGegevenPersoon(karen));
        System.out.println("Te Betalen werknemers " + werchter.printLijstTeCompenserenWerknemers());

        System.out.println(werchter.printOptredens());



    }

}
