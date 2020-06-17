import domain.Rit;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RitTest {

    //SETUP

    Rit eenRit, ritGestopt;
    LocalTime vroegeTijd, lateTijd;

    @Before
    public void setUp(){
        eenRit = new Rit();
        ritGestopt = new Rit();
        ritGestopt.stop(10,LocalTime.of(10,10,10));
        vroegeTijd = LocalTime.of(1,1,1);
        lateTijd = LocalTime.of(23, 30);

    }

    // CONSTRUCTOR TEST

    @Test
    public void Rit_WaardenToegekend_standaard(){
        Rit rit = new Rit();
        assertEquals(rit.getEindTijdstip(), null);
        assertEquals(rit.getAantalKm(), 0.0);
        assertEquals(rit.getStartTijdstip().getMinute(), LocalTime.now().getMinute());

    }




    // STOP TEST
    @Test
    public void Stop_waarden_toegekend(){
        eenRit.stop(10, lateTijd);
        assertEquals(eenRit.getAantalKm(), 10);
        assertEquals(eenRit.getEindTijdstip(), lateTijd);
    }
    @Test (expected=IllegalArgumentException.class)
    public void GooitExeption_AlsKm_0(){
        eenRit.stop(0, lateTijd);
    }





    // ISGESTOPT TEST



    @Test
    public void isGestopt_geeft_false_alsritnietgestopt(){

        assertFalse(eenRit.isGestopt());

    }
    @Test
    public void isGestopt_geeftTrue_AlsRitGestopt(){
        assertTrue(ritGestopt.isGestopt());
    }



}
