package ui;

import domain.Datum;
import domain.Persoon;
import domain.VerjaardagsKalender;

public class UI {

	public static void main(String[] args) {
		VerjaardagsKalender kalender = new VerjaardagsKalender();
		Persoon tim = new Persoon("Frederiks","Tim",new Datum(1,12,2011));
		Persoon tom = new Persoon("Adams","Tom",new Datum(12,12,1999));
		Persoon ann = new Persoon("Alders","Ann",new Datum(1,4,2014));
		Persoon jef = new Persoon("Jackers","Jef",new Datum(1,12,2012));
		Persoon anne = new Persoon("Van anders","Anne",new Datum(4,11,1987));
		
		kalender.voegVerjaardagToe(ann);
		kalender.voegVerjaardagToe(jef);
		kalender.voegVerjaardagToe(tom);
		kalender.voegVerjaardagToe(tim);
		kalender.voegVerjaardagToe(anne);

		System.out.println(kalender);
		System.out.println("________________________________");

		kalender.verwijderPersoon(jef);
		System.out.println(kalender);
		System.out.println("________________________________");

		kalender.verwijderPersoon(tim);
		System.out.println(kalender);
	}

}
