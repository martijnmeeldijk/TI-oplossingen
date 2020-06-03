package domain;

import java.util.*;

public class Spel {

	SpelerGroep spelerGroep;
	Quiz quiz;
	int vraagIndex = 0;
    private List<Opdracht> opdrachten;

	/**
	 * Maakt een nieuw spel aan met de gegeven spelergroep en quiz.
	 * 
	 * @param spelers	de groep van spelers
	 * @param quiz	de quiz
	 */	
	public Spel(SpelerGroep spelers, Quiz quiz) {
		if(spelers == null || quiz == null) throw new IllegalArgumentException("Spelergroep of quiz is leeg");
		this.spelerGroep = spelers;
		this.quiz = quiz;
		opdrachten = new LinkedList<>(quiz.getOpdrachten());
	}

	/**
	 * Geeft aan of er nog opdrachten zijn in de quiz.
	 * 
	 * @return true als er geen opdrachten meer over zijn in de quiz, anders false
	 */
	public boolean isVoorbij() {
		if(vraagIndex == opdrachten.size()) return true;
		return false;
	}

	/**
	 * Geeft de vraag van de volgende opdracht van de quiz.
	 * 
	 * @return de vraag van de volgende opdracht van de quiz
	 */
	public String getVolgendeVraag() {
		return opdrachten.get(vraagIndex).getVraag();
	}

	/**
	 * Controleert of het antwoord juist is, kent punten toe en zet de volgende speler aan beurt. 
	 * Indien het antwoord juist is, krijgt de speler die aan beurt was 10 punten bij. Infien fout worden er geen punten toegekend.
	 * 
	 * @param antwoord	het antwoord van de speler op de vraag
	 */
	public boolean speel(String antwoord) {
        Opdracht opdracht = opdrachten.get(vraagIndex);
        volgendeVraag();

        if(opdracht.getAntwoord().trim().equalsIgnoreCase(antwoord)){
            spelerGroep.getSpelerAanBeurt().verhoogAantalPunten(10);
            return true;
        }
        spelerGroep.getEnVerplaatsSpelerAanBeurt();
        return false;
	}

	/**
	 * Geeft de speler terug met het meeste punten.
	 * 
	 * @return de speler met het meeste punten
	 */
	public Speler getWinnaar() {
	    Speler winnaar = new Speler("winnaar");
	    for(Speler s : spelerGroep.getSpelers()){
	        if(s.getAantalPunten() > winnaar.getAantalPunten()) winnaar = s;
        }
        return winnaar;
	}
    public Set<Speler> getWinnaars() {
	    Set<Speler> winnaars = new HashSet<>();
        int hoogstepunt = 0;
        for(Speler s : spelerGroep.getSpelers()){
            if(s.getAantalPunten() == hoogstepunt){
                winnaars.add(s);
            }
            if(s.getAantalPunten() > hoogstepunt){
                winnaars.clear();
                winnaars.add(s);
            }
        }
        return winnaars;
    }
    public int getHoogstePunt(){
        return getWinnaar().getAantalPunten();
    }

	/**
	 * Geeft de naam van de speler terug die nu aan beurt is. 
	 * 
	 * @return de naam van de speler die nu aan beurt is
	 */
	public String getNaamSpelerAanBeurt() {
		return spelerGroep.getSpelerAanBeurt().getNaam();
	}

    public int getVraagIndex() {
        return vraagIndex;
    }
    public void volgendeVraag(){
	    vraagIndex += 1;
    }
}
