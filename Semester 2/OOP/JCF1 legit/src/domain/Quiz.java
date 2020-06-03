package domain;

import db.OpdrachtDatabank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Quiz {
	
	// TODO Vervang door een gepaste collectie en initialiseer ze
	private ArrayList<Opdracht> opdrachten;
		
	public Quiz(){
	}
	
	public Quiz(ArrayList<Opdracht> opdrachten){// TODO Vervang parameter door een een gepaste collectie
		this.opdrachten = opdrachten;
	}

	public ArrayList<Opdracht> getOpdrachten(){// TODO Vervang returntype door een een gepaste collectie
		return opdrachten;
	}
		
	// hoeveel opdracht objecten zitten er in de opdrachtenCollectie
	public int getAantalOpdrachten(){
		return opdrachten.size();
	}
		
	public boolean isLeeg(){
		return opdrachten.size() == 0;
	}
		
	//return opdrachtobject op plaats index in de opdrachtenCollectie
	public Opdracht getOpdracht(int index) {
		return opdrachten.get(index);
	}
		
	// zet op de plaats index in de opdrachteRij het opdrachtobject opdrachtNieuw
	// en returned de eventuele opdracht die op plaats index in de opdrachtenCollectie al aanwezig is
	public Opdracht setOpdracht(int index, Opdracht opdrachtNieuw) {
		Opdracht oude = null;
		if(opdrachten.get(index) != null){
			oude = opdrachten.get(index);
		}
		opdrachten.set(index, opdrachtNieuw);
		return oude;
	}
		
	//voegt een nieuwe opdracht toe achteraan de opdrachtenCollectie
	public void voegOpdrachtToe(Opdracht opdrachtNieuw){
		if(opdrachtNieuw == null) throw new IllegalArgumentException("opdracht is null");
		opdrachten.add(opdrachtNieuw);
	}
		
	// voegt een nieuwe opdracht toe op de plaats index in de opdrachtenCollectie
	public void voegOpdrachtToe(int index, Opdracht opdrachtNieuw) {
		if(opdrachtNieuw == null) throw new IllegalArgumentException("opdracht is null");
		opdrachten.add(opdrachtNieuw);
	}

	// verwijder de eventuele opdracht op plaats index in de opdrachtenCollectie
	//geeft de verwijderde opdracht terug
	public Opdracht verwijderOpdracht(int index) {
		if(opdrachten.get(index) == null) return null;
		Opdracht opdracht = opdrachten.get(index);
		opdrachten.set(index, null);
		return opdracht;
	}
		
	// print elke opdracht uit de opdrachtenCollectie (volgens toString van Opdracht klasse),
	// elke opdracht op een nieuwe lijn
	public String toString(){
		String result = "";
		for( Opdracht o : opdrachten){
			result += o.toString() + "\n";
		}
		return result;
	}
}
