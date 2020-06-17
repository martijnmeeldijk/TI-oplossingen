package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerjaardagsKalender {
	private Map<DagMaand,List<Persoon>> kalender;
	
	public VerjaardagsKalender(){
		this.kalender = new HashMap<>(1231);
	}
	
	public void voegVerjaardagToe(Persoon p){
		if (p != null){
			DagMaand d = new DagMaand(p.getGeboorteDatum());
			if (!this.kalender.containsKey(d)){
				this.kalender.put(d, new ArrayList<>());
			}

			this.kalender.get(d).add(p);
			Collections.sort(this.kalender.get(d));
			}
			
		}
	
	public void verwijderPersoon(Persoon p){
		if (p!=null){
			DagMaand d = new DagMaand(p.getGeboorteDatum());
			if (this.kalender.containsKey(d)){
				List<Persoon> personen = this.kalender.get(d);
				if (personen != null) {
					this.kalender.get(d).remove(p);
					if (this.kalender.get(d).size() == 0){
						this.kalender.remove(d);
					}
				}
			}
		}
	}
	
	public String toString(){
		String uit = "";
		for (DagMaand d : this.kalender.keySet()){
			uit+= d +  " " + this.kalender.get(d) + ":\n"; 
		}
		return uit;
	}
}
