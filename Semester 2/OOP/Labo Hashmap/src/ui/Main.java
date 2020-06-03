package ui;

import javax.swing.JOptionPane;

import db.Databank;
import domain.AfstandBerekening;

public class Main {
	public static void main(String[] args) {
		try{
			Databank db = new Databank("google_afstanden.txt");
			AfstandBerekening afstandsBerekening = new AfstandBerekening(db.getAfstanden());
			String traject = JOptionPane.showInputDialog("Geef de te bezoeken steden in volgorde gescheiden door een ,");
			
			System.out.println(afstandsBerekening.getOverzichtTraject(traject));
			
			String stadVan = JOptionPane.showInputDialog("Geef een stad, aub");
			String uit = afstandsBerekening.getOverzichtBuurStedenPerAfstandInterval(stadVan);
			System.out.println(uit);
		}catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
