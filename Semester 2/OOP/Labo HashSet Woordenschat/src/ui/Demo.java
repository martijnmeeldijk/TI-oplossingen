package ui;

import java.util.HashSet;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args){
        String eerste = args[0];
        eerste.toLowerCase().replaceAll("[^a-zA-Z^\\s]", "");
        HashSet woorden = new HashSet();

        Scanner scanner = new Scanner(eerste);
        scanner.useDelimiter(" ");
        System.out.println("Origineel: " + eerste);

        double aantal = 0;
        double aantalUniek = 0;
        while(scanner.hasNext()){
            String part = scanner.next();
            if(!woorden.add(part)){
                System.out.println("Duplicaat: " + part);
            }
            else{
                aantalUniek += 1;
            }
            aantal += 1;
        }
        System.out.println("Aantal Woorden: " + aantal);
        System.out.println("Aantal Unieke Woorden: " + aantalUniek);
        System.out.println("Creativiteitsscore: " + Math.round(aantalUniek/aantal*100) + "%");

    }
}
