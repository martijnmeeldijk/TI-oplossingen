package domain;

public class Persoon implements Comparable<Persoon>{
	private String naam, voornaam;
	private Datum geboorteDatum;
	
	public Persoon(String naam, String voornaam, Datum geboorteDatum) {
		if (naam == null || voornaam == null || geboorteDatum == null){
			throw new IllegalArgumentException();
		}
		this.naam = naam;
		this.voornaam = voornaam;
		this.geboorteDatum = geboorteDatum;
	}

	public String getNaam() {
		return naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public Datum getGeboorteDatum() {
		return geboorteDatum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geboorteDatum == null) ? 0 : geboorteDatum.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result + ((voornaam == null) ? 0 : voornaam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persoon other = (Persoon) obj;
		if (geboorteDatum == null) {
			if (other.geboorteDatum != null)
				return false;
		} else if (!geboorteDatum.equals(other.geboorteDatum))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (voornaam == null) {
			if (other.voornaam != null)
				return false;
		} else if (!voornaam.equals(other.voornaam))
			return false;
		return true;
	}
	
	public String toString(){
		return this.naam + ", "   + this.voornaam + " " + this.geboorteDatum;
	}

	@Override
	public int compareTo(Persoon p) {
		if (p == null) return 1;
		int i = this.getGeboorteDatum().compareTo(p.getGeboorteDatum());
		if (i != 0) return i;
		else {
			i = this.getNaam().compareTo(p.getNaam());
			if (i != 0) return i;
			else return this.getVoornaam().compareTo(p.getVoornaam());
		}
	}
	
	
}
