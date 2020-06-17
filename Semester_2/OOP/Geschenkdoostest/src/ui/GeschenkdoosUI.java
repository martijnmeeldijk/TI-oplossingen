package ui;

import domain.*;

import java.time.LocalDate;

public class GeschenkdoosUI {

    public static void main(String[] args) {

        Persoon schenker = new Persoon("Janssens", "Jef", LocalDate.of(1990, 2, 1));
        Persoon ontvanger = new Persoon("Janssens", "Sam", LocalDate.of(2013, 3, 26));
        Geschenk jipenjanneke = new Boek("Jip en Janneke", "Annie MG Schmidt", 9, 5.99);
        Geschenk lego = new SpeelgoedMetMinimumLeeftijd("Lego Starwars", "Lego", 8, 27);
        Geschenk duplo = new Speelgoed("Duplo bus", "Duplo", 15);
        Geschenk niknak = new Snoepgoed("Niknak", LocalDate.of(2019,2,1),1.5);

        Geschenkdoos doos = new Geschenkdoos(schenker, ontvanger, jipenjanneke);
        System.out.println("Geschenkdoos aangemaakt");
        System.out.println("Geschenk toegevoegd:\n\t" + jipenjanneke);

        doos.voegGeschenkToe(duplo);
        System.out.println("Geschenk toegevoegd:\n\t" + duplo);

        System.out.println("\n--PRINT GESCHENKDOOS--");
        System.out.println(doos);

        try {
            doos.voegGeschenkToe(lego);
            System.out.println("\n Geschenk toegevoegd:\n\t" + lego);
        } catch (DomainException e) {
            System.out.println("\nLEGO: " + e.getMessage());
        }

        try {
            doos.voegGeschenkToe(niknak);
            System.out.println("Geschenk toegevoegd:\n\t" + niknak);
        } catch (DomainException e) {
            System.out.println("NIKNAK: " + e.getMessage());
        }
    }
}
