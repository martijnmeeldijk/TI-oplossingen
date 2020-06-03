package domain;

import java.util.Objects;

public class Categorie implements Comparable<Categorie>{
	private int beginAge, verschil;
	
	public Categorie(int verschil){
		this(0,verschil);
	}
	
	private Categorie(int beginAge,int verschil){
		this.setBeginAge(beginAge);
		this.setVerschil(verschil);
	}
	
	private void setBeginAge(int beginAge) {
		if (beginAge < 0 ){
			throw new IllegalArgumentException("geen negatief getal voor leeftijd piemol");
		}
		this.beginAge = beginAge;
	}

	private void setVerschil(int verschil){
		if (verschil <= 0 ){
			throw new IllegalArgumentException("geen negatief/nul voor verschil piemol");
		}
		this.verschil= verschil;
	}
	/**
	 * geeft de categorie terug waarbinnen de gegeven leeftijd ligt
	 * @param leeftijd
	 * @return de categorie waarbinnen de gegeven leeftijd ligt
	 * @throws IllegalArgumentException als de gegeven leeftijd negatief is
	 */
	public static Categorie berekenCategorie(int leeftijd, int verschil){

		int start = leeftijd - leeftijd%verschil;
        return new Categorie(start, verschil);
	}
	
	public Categorie getVolgendeCategorie(){
		return new Categorie(this.beginAge + this.verschil, this.verschil);
	}
	
	public boolean equals(Object o){
		if(o instanceof Categorie){
			Categorie c = (Categorie) o;
			return c.getBeginAge() == this.getBeginAge() && c.getVerschil() == this.getVerschil();
		}
		return false;
	}
	
	public int hashCode(){
		return Objects.hash(beginAge, verschil);
	}

	@Override
	public int compareTo(Categorie arg0) {
		if(this.equals(arg0)) return 0;
		if(this.beginAge > arg0.getBeginAge()){
		    return 1;
        }
        else return -1;
	}

	public String toString(){
		return this.beginAge + " - " + (this.beginAge + this.verschil);
	}

    public int getBeginAge() {
        return beginAge;
    }

    public int getVerschil() {
        return verschil;
    }
}