package domain.model;

public class Student {
	private String naam;
	private String voornaam;
	private int leeftijd;
	private String studierichting;
	
	public Student() {
	}
	
	public Student(String naam, String voornaam, int leeftijd, String studierichting) {
		setNaam(naam);
		setVoornaam(voornaam);
		setLeeftijd(leeftijd);
		setStudierichting(studierichting);
	}
	
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		if(naam != null)
		this.naam = naam;
		else throw new IllegalArgumentException();
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		if(voornaam != null)
		this.voornaam = voornaam;
		else throw new IllegalArgumentException();
	}
	public int getLeeftijd() {
		return leeftijd;
	}
	public void setLeeftijd(int leeftijd) {
		if(leeftijd >= 0)
		this.leeftijd = leeftijd;
		else throw new IllegalArgumentException();
	}
	public String getStudierichting() {
		return studierichting;
	}
	public void setStudierichting(String studierichting) {
		if(studierichting != null)
		this.studierichting = studierichting;
		else throw new IllegalArgumentException();
	}
	
	public String format() {
		return getNaam()+" "+getVoornaam()+" ("+getLeeftijd()+" jaar): "+getStudierichting();
	}
	
	public boolean heeftNaam(String naam,String voornaam) {
		return naam.equals(this.getNaam()) && voornaam.equals(this.getVoornaam());
	}
	
}
