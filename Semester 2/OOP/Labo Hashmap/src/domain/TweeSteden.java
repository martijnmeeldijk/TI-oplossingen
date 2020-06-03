package domain;

import java.util.List;
import java.util.Objects;

public class TweeSteden {

	private String van, naar;

	/**
	 * Inhoud van 2 TweeSteden objecten zijn gelijk:
	 * 	de steden van en naar mogen gewisseld zijn in het andere object
	 *  of op een andere manier met hoofdletters geschreven zijn.
	 */
	public boolean equals(Object o){
		if(o instanceof TweeSteden){
			TweeSteden t = (TweeSteden)o;
			String van1 = this.getVan().toLowerCase();
			String naar1 = this.getNaar().toLowerCase();
			String van2 = t.getVan().toLowerCase();
			String naar2 = t.getNaar().toLowerCase();
			return (van1.equals(van2) && naar1.equals(naar2)) || (van1.equals(naar2) && van2.equals(naar1));
		}
		return false;
	}

	public String toString(){
		return "Van " + this.getVan() + " naar " + this.getNaar() ;
	}
	
	public int hashCode(){

	    return Objects.hash(van.toLowerCase(), naar.toLowerCase()) + Objects.hash(naar.toLowerCase(), van.toLowerCase());

	}

	public TweeSteden(String van, String naar){
		this.setVan(van);
		this.setNaar(naar);
	}
	public String getVan() {
		return van;
	}
	private void setVan(String van) throws IllegalArgumentException{
		if (van == null){
			throw new IllegalArgumentException();
		}
		
		this.van = van;
	}
	public String getNaar() {
		return naar;
	}
	private void setNaar(String naar) throws IllegalArgumentException{
		if (naar == null){
			throw new IllegalArgumentException();
		}
		
		this.naar = naar;
	}
	
}
