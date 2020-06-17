package domain;
import java.util.*;
import java.util.Map.Entry;


public class CategoriesPerLeeftijd {
	private SortedMap<Categorie,List<String>> map ;
	private int verschil;
	
	public CategoriesPerLeeftijd(int verschil){
		if (verschil <= 0){
			throw new IllegalArgumentException();
		}
		this.map= new TreeMap<>();
		this.verschil= verschil;
	}
	
	public void voegToe(int leeftijd, String naam){
		Categorie c = Categorie.berekenCategorie(leeftijd, verschil);
		if(map.containsKey(c)){
            map.get(c).add(naam);
        }
        else{
            List<String> namen = new ArrayList<>();
            namen.add(naam);
            map.put(c, namen);

        }
	}
	
	public String toString(){
		String uit = categorieenToString();
		uit += gebruikteCategorieenMetNamenToString();
		return uit;
	}

	private String categorieenToString() {
		Categorie max = grootstMogelijkeCategorie();
		String uit = "Calculated categories:\n";
		Categorie categorie = new Categorie(verschil);
		while (!categorie.equals(max)){
			uit+= categorie + ", ";
			categorie = categorie.getVolgendeCategorie();
		}
		
		uit += max + "\n";
		return uit;
	}

	private String gebruikteCategorieenMetNamenToString() {
		String uit = new String();
		Iterator<Entry<Categorie, List<String>>> it = this.map.entrySet().iterator();
		while(it.hasNext()){
			Entry<Categorie, List<String>> entry = it.next();
			
			uit+= entry.getKey().toString() + " : ";
			String namen = entry.getValue().toString();
			uit+= namen.substring(1,namen.length()-1) + "\n";
		}
		return uit;
	}

	private Categorie grootstMogelijkeCategorie() {
		Categorie max;
		if(this.map.isEmpty()){
			max = new Categorie(verschil);
		} else {
			max = this.map.lastKey();
		}
		return max;
	}


}

