package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Deze klasse stelt een adresboek voor.
 */
public class Adresboek implements Cloneable {

	private Set<Contact> contacten;
	

	/**
	 * Constructor voor het leeg adresboek.
	 */
	public Adresboek() {
		this(new HashSet<Contact>());
	}
	
	/**
	 * Constructor voor een adresboek met gegeven contacten.
	 * 
	 * @param contacten De contacten voor het adresboek
	 */
	public Adresboek(Set<Contact> contacten) {
		this.contacten = contacten;
	}

	/**
	 * Retourneert de contacten het het adreboek.
	 * 
	 * @return De contacten van het adresboek
	 */
	public Set<Contact> getContacten() {
		return contacten;
	}


	/**
	 * Geeft een adresboek-object terug, met daarin de gemeenschappelijke contacten van het adresboek, vergeleken
	 * met het adresboek dat als parameter meegegeven wordt.
	 * 
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek met gemeenschappelijke contacten.
	 * @ Wanneer het meegegeven adresboek ongeldig is.
	 */
	public Adresboek gemeenschappelijkeContacten(Adresboek teVergelijken){
		Set<Contact> gemeenschappelijk = new HashSet<>();
		gemeenschappelijk.addAll(contacten);
		gemeenschappelijk.retainAll(teVergelijken.getContacten());
		Adresboek dit = new Adresboek(gemeenschappelijk);
		// .retainAll gebruiken
		return dit;
	}
	
	/**
	 * Geeft een adresboek-object terug, waarin alle vrienden van het huidige adresboek en het meegegeven adresboek staan.
	 * Er staan geen dubbels in.
	 * 
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek waarin alle contacten van de samengevoegde adresboeken staan, zonder dubbels.
	 * @ Wanneer het meegegeven adresboek ongeldig is.
	 */
	public Adresboek gezamelijkeContacten(Adresboek teVergelijken) {

		HashSet<Contact> h = new HashSet<>();
		h.addAll(teVergelijken.getContacten());
		h.addAll(contacten);

		return new Adresboek(h);
	}
	
	/**
	 * Geeft een adresboek-object terug, waarin alle vrienden van het huidige adresboek 
	 * die niet voorkomen in het meegegeven adresboek.
	 * 
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek waarin de contacten staan die dit adresboek wel heeft het het meegegeven adresboek niet.
	 * @ Wanneer het meegegeven adresboek ongeldig is.
	 */
	public Adresboek verschillendeContacten (Adresboek teVergelijken){
	    Set<Contact> a = teVergelijken.clone().getContacten();
        Set<Contact> b = this.clone().getContacten();


	    b.removeAll(a);



	    Adresboek terug = new Adresboek(b);
        System.out.println("contacten\n" + contacten);
        System.out.println("\ntevergelijken\n" + teVergelijken);
        System.out.println("\nSamen:\n" + terug);


		return terug;
	}

	public Adresboek clone(){
	    Set<Contact> iets = new HashSet<>();
	    for(Contact c : this.contacten){
	        iets.add(c.clone());
        }
        return new Adresboek(iets);
    }


	/**
	 * Voegt een contact toe aan het adresboek
	 * 
	 * @param contact Het contact dat toegevoegd dient te worden.
	 * @return true wanneer het contact nog niet reeds bestond in het adresboek
	 * @ Wanneer een ongeldig contact meegegeven wordt.
	 */
	public boolean voegToe(Contact contact) {
		return contacten.add(contact);
	}
	
	/**
	 * Voegt een nieuw contact toe aan het adresboek. Dit contact bevat de meegegegeven achternaam, voornaam en telefoonnummer.
	 * @param achternaam De achternaam van het contact dat toegevoegd wordt aan het adresboek.
	 * @param voornaam De voornaam van het contact dat toegevoegd wordt aan het adresboek.
	 * @param telefoonnummer Het telefoonnummer van het contact dat toegevoegd wordt aan het adresboek.
	 * @return true wanneer het contact nog niet reeds bestond in het adresboek
	 * @ Wanneer een ongeldig gegeven meegegeven wordt om een contact te kunnen maken.
	 */
	public boolean voegToe (String achternaam, String voornaam, int telefoonnummer){
		Contact c = new Contact(achternaam, voornaam, Integer.toString(telefoonnummer));
		return true;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString(){
	    String s = "";
		for(Contact c : contacten){
		    s += c.toString() + "\n";
        }
        return s;
	}

	public int getAantalContacten(){
	    return contacten.size();
    }
    public boolean contains(Object o){

       return contacten.contains(o);

    }
}

