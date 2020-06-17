package db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import domain.TweeSteden;

public class DatabankTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void Databank_leest_alle_afstanden_in() throws Exception {
		Databank db = new Databank("google_afstanden.txt");
		Map<TweeSteden, Double> afstandenUitDb = db.getAfstanden();
		assertEquals(342, afstandenUitDb.size());
	}

	@Test
	public void Databank_leest_de_steden_in_zonder_land() throws Exception {
		Databank db = new Databank("google_afstanden.txt");
		Map<TweeSteden, Double> afstandenUitDb = db.getAfstanden();
		assertTrue(afstandenUitDb.containsKey(new TweeSteden("Ninove", "Tienen")));
	}

	@Test
	public void Databank_leest_de_afstanden_altijd_op_dezelfde_manier_in() throws Exception {
		Databank db1 = new Databank("google_afstanden.txt");
		Map<TweeSteden, Double> afstandenUitDb1 = db1.getAfstanden();
		Iterator<TweeSteden> iteratatorDb1 = afstandenUitDb1.keySet().iterator();
		
		Databank db2 = new Databank("google_afstanden.txt");
		Map<TweeSteden, Double> afstandenUitDb2 = db2.getAfstanden();		
		Iterator<TweeSteden> iteratorDb2 = afstandenUitDb2.keySet().iterator();
		
		for(int i = 0; i < afstandenUitDb1.size(); i++) {
			assertEquals(iteratatorDb1.next(),iteratorDb2.next());
		}
	}

}
