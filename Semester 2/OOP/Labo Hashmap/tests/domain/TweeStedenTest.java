package domain;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class TweeStedenTest {

	private TweeSteden hasseltLeuven = new TweeSteden("hasselt", "leuven");
	private TweeSteden zelfdeSteden = new TweeSteden("hasselt", "leuven");
	private TweeSteden zelfdeStedenInAndereVolgorde = new TweeSteden("leuven", "hasselt");
	private TweeSteden zelfdeStedenMetHoofdLetter = new TweeSteden("Hasselt", "Leuven");
	private TweeSteden genkLeuven = new TweeSteden("genk", "leuven");
	private TweeSteden genkBrussel = new TweeSteden("genk", "brussel");
	
	@Test
	public void hashCode_moet_hetzelfde_resultaat_geven_als_steden_gelijk_zijn() {
		assertEquals(hasseltLeuven.hashCode(), zelfdeStedenInAndereVolgorde.hashCode());
	}
	
	@Test
	public void hashCode_moet_hetzelfde_resultaat_geven_als_steden_gewisseld_zijn() {
		assertEquals(hasseltLeuven.hashCode(), zelfdeSteden.hashCode());
	}
	
	@Test
	public void hashCode_moet_hetzelfde_resultaat_geven_als_steden_met_hoofdletters_zijn() {
		assertEquals(hasseltLeuven.hashCode(), zelfdeStedenMetHoofdLetter.hashCode());
	}
	
	@Test
	public void hashCode_geeft_liefst_een_verschillend_resultaat_geven_als_steden_verschillend_zijn() {
		assertNotSame(hasseltLeuven.hashCode(), genkBrussel.hashCode());
	}
	
	@Test
	public void hashCode_kan_hetzelfde_resultaat_geven_als_steden_verschillend_zijn() {
		//Opmerking: het resultaat van de hashCode() methode kan hetzelfde zijn als de steden verschillend zijn. Vermijd dit echter liefst zoveel mogelijk.
		//Probeer deze testcase eens uit: indien ze slaagt, geen probleem, je hebt je hashcode() wellicht gebaseerd op de hashCode() van String().
		//Voor meer info, zie: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#hashCode()
		//Indien ze faalt (en de andere testen slagen): zeker geen probleem! Je hebt wellicht een heel goede hashfunctie geschreven. Zet deze test dan wel in commentaar.
		TweeSteden dammeHalen = new TweeSteden("damme", "halen");
		TweeSteden hammeDalen = new TweeSteden("hamme", "dalen");
		assertEquals(dammeHalen.hashCode(), hammeDalen.hashCode());
	}

	@Test
	public void equals_moet_true_geven_als_steden_gelijk_zijn() {
		assertTrue(hasseltLeuven.equals(zelfdeSteden));
		assertTrue(zelfdeSteden.equals(hasseltLeuven));
	}

	@Test
	public void equals_moet_true_geven_als_steden_gewisseld_zijn() {
		assertTrue(hasseltLeuven.equals(zelfdeStedenInAndereVolgorde));
		assertTrue(zelfdeStedenInAndereVolgorde.equals(hasseltLeuven));
	}

	@Test
	public void equals_moet_true_geven_als_steden_met_hoofdletters_zijn() {
		assertTrue(hasseltLeuven.equals(zelfdeStedenMetHoofdLetter));
		assertTrue(zelfdeStedenMetHoofdLetter.equals(hasseltLeuven));
	}

	@Test
	public void equals_moet_false_geven_als_een_van_beide_steden_verschillend_is() {
		assertFalse(hasseltLeuven.equals(genkLeuven));
		assertFalse(genkLeuven.equals(hasseltLeuven));
	}

	@Test
	public void equals_moet_false_geven_als_beide_steden_verschillend_zijn() {
		assertFalse(hasseltLeuven.equals(genkBrussel));
		assertFalse(genkLeuven.equals(hasseltLeuven));
	}
}
