package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpelerGroep {

	Queue<Speler> spelers = new LinkedList<>();

	/**
	 * Maakt een nieuwe speler aan met de gegeven naam en voegt de speler toe aan de groep.
	 * 
	 * @param spelerNaam	de naam van de speler
	 */
	public void registreer(String spelerNaam) {
		if(spelerNaam.isEmpty()) throw new IllegalArgumentException("Spelernaam is leeg");
		Speler s = new Speler(spelerNaam);
		spelers.add(s);
	}

	/**
	 * Geeft een lijst terug van alle spelers die geregistreerd zijn.
	 * 
	 * @return een lijst met alle spelers
	 */
	public List<Speler> getSpelers() {
		return (List)spelers;
	}

	/**
	 * Geeft de speler terug die nu aan beurt is. 
	 * 
	 * @return de speler die nu aan beurt is
	 */
	public Speler getSpelerAanBeurt() {
		return spelers.peek();
	}

	/**
	 * Geeft de speler terug die nu aan beurt is en zet de beurt op voorbij. 
	 * Telkens men deze methode opgeroept, wordt de volgende speler dus aan beurt gezet.
	 * 
	 * @return de speler die nu aan beurt is
	 */
	public Speler getEnVerplaatsSpelerAanBeurt() {
		spelers.add(spelers.poll());
		return spelers.peek();
	}

	/**
	 * Geeft de speler terug met het meeste punten.
	 * 
	 * @return de speler met het meeste punten
	 */
	public Speler getWinnaar() {
		Speler max = new Speler("azf");
		for(Speler s : spelers){
			if(s.getAantalPunten() > max.getAantalPunten()){
				max = s;
			}
		}
		return max;
	}
}
