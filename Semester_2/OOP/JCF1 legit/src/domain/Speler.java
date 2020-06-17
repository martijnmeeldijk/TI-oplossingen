package domain;

public class Speler {
	private String naam;
	private int aantalPunten;
	
	public Speler(String naam){
		setNaam(naam);
	}
	public void verhoogAantalPunten(int aantal) {
		setAantalPunten(getAantalPunten() + aantal);
	}
	
	public String getNaam() {
		return naam;
	}
	private void setNaam(String naam) {
		this.naam = naam;
	}
	public int getAantalPunten() {
		return aantalPunten;
	}
	private void setAantalPunten(int aantalPunten) {
		this.aantalPunten = aantalPunten;
	}
	public boolean equals(Object object) {
		boolean gelijk = false;
		if (object instanceof Opdracht) {
			Speler opdracht = (Speler) (object);

			gelijk = this.getAantalPunten() == opdracht.getAantalPunten()
					&& this.getNaam().equals(opdracht.getNaam());
		}
		return gelijk;
	}
}
