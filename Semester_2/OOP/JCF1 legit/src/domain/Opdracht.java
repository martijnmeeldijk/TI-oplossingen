package domain;

import java.util.Objects;

public class Opdracht{

	public static final String CATEGORIE_AARDRIJKSKUNDE = "Aardrijkskunde";
	public static final String CATEGORIE_GESCHIEDENIS = "Geschiedenis";
	public static final String CATEGORIE_NEDERLANDS = "Nederlands";
	public static final String CATEGORIE_WISKUNDE = "Wiskunde";
	public static final String CATEGORIE_WETENSCHAPPEN = "Wetenschappen";

	public static final String[] CATEGORIEEN = { CATEGORIE_AARDRIJKSKUNDE,
			CATEGORIE_GESCHIEDENIS, CATEGORIE_NEDERLANDS, CATEGORIE_WISKUNDE,
			CATEGORIE_WETENSCHAPPEN };

	/**
	 * Deze id wordt toegekend door de OpdrachtDatabase klasse wanneer een
	 * opdracht aan de opdrachtendatabase wordt toegevoegd. (deze ID begint met
	 * 1 en wordt altijd met 1 verhoogd)
	 */
	private int opdrachtID;

	/**
	 * De String vraag bevat de vraag die bij de opdracht behoort. Op een vraag
	 * moet kunnen geantwoord worden met 1 woord of getal. Voorbeeld: Wat is
	 * de hoofdstad van Frankrijk?
	 */
	private String vraag;

	/**
	 * De String antwoord bevat het verwachte antwoord op de vraag. Voorbeeld
	 * bij voorgaande vraag is het juiste antwoord: Parijs.
	 */
	private String antwoord;

	/**
	 * De boolean isHoofdletterGevoelig geeft aan of men bij het evalueren van
	 * het antwoord al dan niet rekening zal houden met het gebruik van
	 * hoofdletters. Indien niet zal bijvoorbeeld Parijs en parijs als hetzelfde
	 * antwoord beschouwd worden.
	 */
	private boolean isHoofdletterGevoelig;

	/**
	 * De String antwoordhint is een hulp voor de quizkandidaat bij het zoeken
	 * naar het juiste antwoord. Voorbeeld: bij de bovenstaande vraag kan een
	 * antwoordhint zijn: Men vindt er de Eifel toren. Een antwoordhint is
	 * optioneel bij een opdracht (hoeft niet verplicht ingevuld te worden bij
	 * elke opdracht)
	 */
	private String antwoordHint;

	/**
	 * De String categorie geeft aan tot welke categorie deze opdracht behoort.
	 * We maken opdrachten van 5 categorien: Aardrijkskunde, Geschiedenis,
	 * Nederlands, Wetenschappen en Wiskunde
	 */
	private String categorie;

	/**
	 * De auteur is de naam van wie heeft deze opdracht bedacht.
	 */
	private String auteur;

	/**
	 * Contructor voor het maken van een opdracht MET hint
	 * 
	 * @param id
	 *            de id voor deze opdracht (moet uit de opdrachten db komen)
	 * @param vraag
	 *            de vraag voor deze opdracht
	 * @param antwoord
	 *            het 1-woord-of-getal antwoord
	 * @param hoofdlettergevoelig
	 *            geeft aan of bij het antwoord rekening gehouden moet worden
	 *            met hoofdletters
	 * @param hint
	 *            de antwoord-hint
	 * @param categorie
	 *            een van de vijf bovenaan gedefinieerde categorieen
	 * @param auteur
	 *            de naam van de bedenker van deze opdracht
	 */
	public Opdracht(int id, String vraag, String antwoord,
			boolean hoofdlettergevoelig, String hint, String categorie,
			String auteur) {
		this.opdrachtID = id;
		this.vraag = vraag;
		this.antwoord = antwoord;
		this.isHoofdletterGevoelig = hoofdlettergevoelig;
		this.antwoordHint = hint;
		this.categorie = categorie;
		this.auteur = auteur;
	}

	/**
	 * Constructor voor het maken van een opdracht ZONDER hint
	 * 
	 * @param id
	 *            de id voor deze opdracht (moet uit de opdrachten db komen)
	 * @param vraag
	 *            de vraag voor deze opdracht
	 * @param antwoord
	 *            het 1-woord-of-getal antwoord
	 * @param hoofdlettergevoelig
	 *            geeft aan of bij het antwoord rekening gehouden moet worden
	 *            met hoofdletters
	 * @param categorie
	 *            categorie een van de vijf bovenaan gedefinieerde categorieen
	 * @param auteur
	 *            de naam van de bedenker van deze opdracht
	 */
	public Opdracht(int id, String vraag, String antwoord,
			boolean hoofdlettergevoelig, String categorie, String auteur) {
		this(id,vraag, antwoord, hoofdlettergevoelig,
				"Er werd geen hint voorzien voor deze opdracht",
				categorie, auteur);
	}

	public int getOpdrachtID() {
		return opdrachtID;
	}

	public String getVraag() {
		return vraag;
	}

	public String getAntwoord() {
		return antwoord;
	}

	public boolean isHoofdletterGevoelig() {
		return isHoofdletterGevoelig;
	}

	public String getAntwoordHint() {
		return antwoordHint;
	}

	public String getCategorie() {
		return categorie;
	}

	public String getAuteur() {
		return auteur;
	}


	/**
	 * Methode om de gelijkheid van twee opdrachten te checken
	 * 
	 * @return true als ze gelijk zijn
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Opdracht opdracht = (Opdracht) o;
		return opdrachtID == opdracht.opdrachtID &&
				isHoofdletterGevoelig == opdracht.isHoofdletterGevoelig &&
				Objects.equals(vraag, opdracht.vraag) &&
				Objects.equals(antwoord, opdracht.antwoord) &&
				Objects.equals(antwoordHint, opdracht.antwoordHint) &&
				Objects.equals(categorie, opdracht.categorie) &&
				Objects.equals(auteur, opdracht.auteur);
	}

	/**
	 * Methode om deze opdracht volledig uit te schrijven
	 */
	public String toString() {
		String dezeOpdracht = "";
		dezeOpdracht += getOpdrachtID() + " - " + getCategorie() + "\n";
		dezeOpdracht += "auteur: " + getAuteur() + "\n";
		dezeOpdracht += "vraag: " + getVraag() + "\n";
		dezeOpdracht += "hint: " + getAntwoordHint() + "\n";
		dezeOpdracht += (isHoofdletterGevoelig() ? "" : "niet ") + "hoofdlettergevoelig \n";
		dezeOpdracht += "antwoord: " + getAntwoord() + "\n";
		dezeOpdracht += "---------------------------------------------";
		return dezeOpdracht;
	}

}
