import domain.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BoekTest {
    Boek boekje;
    @Before
    public void setUp(){
        boekje = new Boek("Haasje Over", "Haasje Over", 20,69 );
    }

    @Test
    public void Constructor_Test_Dat_Moest_absoluut_van_Mevr_Baerts_maar_ik_heb_daar_eigenlijk_niet_zo_veel_zin_in(){
        assertEquals("Haasje Over", boekje.getTitel());
        assertEquals("Adolf H.", boekje.getAuteur());
        assertEquals(12, boekje.getPrijs());
        assertEquals(69, boekje.getAantalPaginas());

        //Deze test kijkt alleen na of juist ingevoerde waarden een goed resultaat bekomen
        //Ik ga geen test schrijven die foute resultaten uitprobeert, want als u mijn andere
        // commentaren hebt gelezen weet u hoe dat zal aflopen
    }

    @Test (expected = DomainException.class)
    public void voeg_illegaal_geschenk_toe_geeft_exception(){
        SpeelgoedMetMinimumLeeftijd geschenk = new SpeelgoedMetMinimumLeeftijd("iets", "de pabo", 100, 20);
        Persoon zender = new Persoon("Billy", "Dutroux", LocalDate.of(2001,12,2));
        Persoon onvanger = new Persoon("Johnny", "Denver", LocalDate.of(2007, 3,2));
        Geschenkdoos doos = new Geschenkdoos(onvanger, zender,geschenk);
    }



}
