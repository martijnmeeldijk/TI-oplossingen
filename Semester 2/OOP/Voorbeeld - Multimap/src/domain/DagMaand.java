package domain;

public class DagMaand implements Comparable<DagMaand>{
	private int dag, maand;

	public DagMaand(int dag, int maand) {
		this.dag = dag;
		this.maand = maand;
	}

	public DagMaand(Datum geboorteDatum) {
		if (geboorteDatum != null){
			this.dag = geboorteDatum.getDay();
			this.maand = geboorteDatum.getMonth();
		} else throw new IllegalArgumentException();
		
	}

	@Override
	public int hashCode() {
		
		return maand * 100 + dag;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DagMaand other = (DagMaand) obj;
		if (dag != other.dag)
			return false;
		if (maand != other.maand)
			return false;
		return true;
	}
	
	public String toString(){
		return this.dag + " " + this.maand;
	}

	@Override
	public int compareTo(DagMaand d) {
		if (d == null) return 1;
		else if (this.maand < d.maand) return -1;
		else if (this.maand > d.maand) return 1;
		else return this.dag - d.dag;
	}
}
