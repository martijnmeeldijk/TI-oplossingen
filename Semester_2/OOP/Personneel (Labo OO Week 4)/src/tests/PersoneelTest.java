import domain.Arbeider;
import domain.Personeelslid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersoneelTest {

    Arbeider dirk, pipo, dirk2;

    @Before
    public void setUp() {
        dirk = new Arbeider("A", "Dirk", 500);
        pipo = new Arbeider("B", "Pipo", 2);
        dirk2 = new Arbeider("A","Dirk",500);
    }

    @Test
    public void test_Loonberekening(){

        dirk.setUren(50);
        assertEquals(dirk.berekenLoon(), 25000);
        pipo.setUren(10);
        assertEquals(pipo.berekenLoon(), 20);
    }

    @Test
    public void test_Equals(){

        assertFalse(dirk.equals(pipo));
        assertTrue(dirk.equals(dirk2));
    }





}
