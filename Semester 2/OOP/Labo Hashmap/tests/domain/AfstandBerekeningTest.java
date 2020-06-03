package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import db.Databank;

public class AfstandBerekeningTest {
	
	private String google_afstanden = "google_afstanden.txt";
	private Databank db = new Databank(google_afstanden);
	private AfstandBerekening afstandBerekening;
	private double toegelatenAfrondingsfout = 0.001;

	@Before
	public void setUp() throws Exception {
		afstandBerekening = new AfstandBerekening(db.getAfstanden());
	}
	
	@Test
	public void AfstandBerekening_maakt_afstandBerekening_met_aantal_afstanden_zelfde_als_in_input() {
		assertTrue(afstandBerekening.getAantalAfstanden() > 0);
		assertEquals(db.getAfstanden().size(), afstandBerekening.getAantalAfstanden());
	}
	
	@Test
	public void AfstandBerekening_maakt_afstandBerekening_met_alle_afstanden_zijn_groter_dan_0() {
		for( Entry<TweeSteden, Double> e : afstandBerekening.iterator()) {
			assertTrue(e.getValue() > 0);
		}
	}
	
	@Test
	public void getAfstandTraject_geeft_de_som_van_alle_afstanden_tussen_de_steden_van_het_traject() {
		String trajectDatSteedsVergrootWordt = "Schoten,Brussels";
		double startAfstand = afstandBerekening.getAfstandTraject(trajectDatSteedsVergrootWordt);

		double totaleAfstand = startAfstand;
		
		String[] andereSteden = {"Ninove","Tienen","Verviers","Ghent","Sint-Jans-Molenbeek"}; 
		String vorigeStad = "Brussels";
		double afstandDieErbijKomt;

		for (String stad : andereSteden) {
			afstandDieErbijKomt = afstandBerekening.getAfstandTraject(vorigeStad + "," + stad);
			
			trajectDatSteedsVergrootWordt += "," + stad;
			totaleAfstand += afstandDieErbijKomt;
			
			assertEquals(totaleAfstand, afstandBerekening.getAfstandTraject(trajectDatSteedsVergrootWordt), toegelatenAfrondingsfout);
			vorigeStad = stad;
		}
	}
	
	@Test
	public void getAfstandTraject_geeft_het_totaal_aantal_km_van_de_eerste_tot_de_laatste_stad_in_het_gegeven_lijst(){
		String[] steden = {"Ninove","Tienen","Verviers","Ghent"};
		List<String> deeltraject = Arrays.asList(steden);
		
		afstandBerekening.getAfstandTraject(deeltraject);
		
		assertEquals(89.3 + 83.3 + 213, afstandBerekening.getAfstandTraject(deeltraject), toegelatenAfrondingsfout);
	}

	@Test
	public void getAfstandTraject_geeft_het_totaal_aantal_km_van_de_eerste_tot_de_laatste_stad_in_het_gegeven_string() {
		String[] steden = {"Ninove","Tienen","Verviers","Ghent"};
		List<String> stedenLijst = Arrays.asList(steden); 
		String trajectString = stedenLijst.toString();

		assertEquals(89.3 + 83.3 + 213, afstandBerekening.getAfstandTraject(trajectString), toegelatenAfrondingsfout);
	}

	@Test
	public void getAfstandTraject_geeft_zelfde_afstand_als_traject_lijst_in_omgekeerde_volgorde() {
		String[] namen = {"Evergem","Leuven","Ninove","Tienen","Verviers","Ghent","Sint-Jans-Molenbeek"};
		List<String> steden = Arrays.asList(namen); 
		double afstandSteden = afstandBerekening.getAfstandTraject(steden);
		
		Collections.reverse(steden);
		double afstandStedenGespiegeld = afstandBerekening.getAfstandTraject(steden);
		
		assertEquals(afstandSteden, afstandStedenGespiegeld, toegelatenAfrondingsfout);
	}

	@Test
	public void getAfstandTraject_geeft_zelfde_afstand_als_traject_string_in_omgekeerde_volgorde() {
		String[] namen = {"Evergem","Leuven","Ninove","Tienen","Verviers","Ghent","Sint-Jans-Molenbeek"};
		List<String> steden = Arrays.asList(namen); 
		double afstandSteden = afstandBerekening.getAfstandTraject(steden.toString());
		
		Collections.reverse(steden);
		double afstandStedenGespiegeld = afstandBerekening.getAfstandTraject(steden.toString());
		
		assertEquals(afstandSteden, afstandStedenGespiegeld, toegelatenAfrondingsfout);
	}
	
	@Test
	public void getTrajectOnderdelen_geeft_alle_trajectonderdelen_van_de_eerste_tot_de_laatste_stad_in_het_gegeven_lijst() {
		String[] steden = {"Ninove","Tienen","Verviers","Ghent"};
		List<String> stedenLijst = Arrays.asList(steden); 
		Map<TweeSteden, Double> deelTrajecten = afstandBerekening.getTrajectOnderdelen(stedenLijst);

		assertEquals(3, deelTrajecten.size());
		assertTrue(deelTrajecten.containsKey(new TweeSteden("Ninove","Tienen")));
		assertTrue(deelTrajecten.containsKey(new TweeSteden("Tienen","Verviers")));
		assertTrue(deelTrajecten.containsKey(new TweeSteden("Verviers","Ghent")));
	}

	@Test
	public void getTrajectOnderdelen_geeft_alle_trajectonderdelen_van_de_eerste_tot_de_laatste_stad_in_het_gegeven_string() {
		String[] steden = {"Ninove","Tienen","Verviers","Ghent"};
		List<String> stedenLijst = Arrays.asList(steden); 
		String trajectString = stedenLijst.toString();
		Map<TweeSteden, Double> deelTrajecten = afstandBerekening.getTrajectOnderdelen(trajectString);

		assertEquals(3, deelTrajecten.size());
		assertTrue(deelTrajecten.containsKey(new TweeSteden("Ninove","Tienen")));
		assertTrue(deelTrajecten.containsKey(new TweeSteden("Tienen","Verviers")));
		assertTrue(deelTrajecten.containsKey(new TweeSteden("Verviers","Ghent")));
	}

	@Test
	public void getTrajectOnderdelen_geeft_zelfde_onderdelen_als_traject_lijst_in_omgekeerde_volgorde() {
		String[] namen = {"Evergem","Leuven","Ninove","Tienen"};
		List<String> steden = Arrays.asList(namen); 
		Map<TweeSteden, Double> deelTrajecten = afstandBerekening.getTrajectOnderdelen(steden);
		
		Collections.reverse(steden);
		Map<TweeSteden, Double> deelTrajectenGespiegeld = afstandBerekening.getTrajectOnderdelen(steden);
		
		assertEquals(deelTrajecten, deelTrajectenGespiegeld);
	}

	@Test
	public void getTrajectOnderdelen_geeft_zelfde_onderdelen_als_traject_string_in_omgekeerde_volgorde() {
		String[] namen = {"Evergem","Leuven","Ninove","Tienen"};
		List<String> steden = Arrays.asList(namen); 
		Map<TweeSteden, Double> deelTrajecten = afstandBerekening.getTrajectOnderdelen(steden.toString());
		
		Collections.reverse(steden);
		Map<TweeSteden, Double> deelTrajectenGespiegeld = afstandBerekening.getTrajectOnderdelen(steden.toString());
		
		assertEquals(deelTrajecten, deelTrajectenGespiegeld);
	}
	
	@Test
	public void getBuurStedenPerAfstandInterval_geeft_buursteden_alfabetisch_verdeeld_over_intervallen_van_50_km() {
		Map<Integer, List<String>> result = afstandBerekening.getBuurStedenPerAfstandInterval("Turnhout");
		
		assertEquals("Alle provincie hoofdsteden vallen binnen de 200 km", 4, result.keySet().size());
		
		String[] burenOpMinderDan50GesorteerdOpNaam = {"Antwerp"};
		String[] burenOpMinderDan100GesorteerdOpNaam = {"Brussels", "Leuven", "Tienen"};
		String[] burenOpMinderDan150GesorteerdOpNaam = {"Ghent"}; 
		String[] burenOpMinderDan200GesorteerdOpNaam = {"Charleroi"}; 
		
		assertEquals("Er is slechts 1 stad binnen de 50 km", Arrays.asList(burenOpMinderDan50GesorteerdOpNaam), result.get(0));
		assertEquals("Er zijn slechts 3 steden binnen de 100 km", Arrays.asList(burenOpMinderDan100GesorteerdOpNaam), result.get(1));
		assertEquals("Er is slechts 1 stad binnen de 150 km", Arrays.asList(burenOpMinderDan150GesorteerdOpNaam), result.get(2));
		assertEquals("Er is slechts 1 stad binnen de 200 km", Arrays.asList(burenOpMinderDan200GesorteerdOpNaam), result.get(3));
		
	}
	
	@Test
	public void getOverzichtTraject_geeft_string_met_traject_onderdelen_en_totale_afstand_voor_gegeven_lijst_steden() {
		String[] namen = {"Evergem","Leuven","Ninove","Tienen"};
		List<String> steden = Arrays.asList(namen); 
		
		String overzicht = "Van Evergem naar Leuven: 98.5 km\nVan Leuven naar Ninove: 71.3 km\nVan Ninove naar Tienen: 89.3 km\n\nTotaal aantal km: 259.1 km";
		assertEquals(overzicht, afstandBerekening.getOverzichtTraject(steden));
		
	}
	
	@Test
	public void getOverzichtTraject_geeft_string_met_traject_onderdelen_en_totale_afstand_voor_gegeven_string_van_steden() {
		String[] namen = {"Evergem","Leuven","Ninove","Tienen"};
		List<String> steden = Arrays.asList(namen); 
		
		String overzicht = "Van Evergem naar Leuven: 98.5 km\nVan Leuven naar Ninove: 71.3 km\nVan Ninove naar Tienen: 89.3 km\n\nTotaal aantal km: 259.1 km";
		assertEquals(overzicht, afstandBerekening.getOverzichtTraject(steden.toString()));
		
	}
}
