package domain;


import javafx.beans.property.ObjectProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

public class OptredenTest {

    Artiest willy;
    Artiest willy2;
    Artiest xink ;
    Artiest vijandvechters;
    Artiest pinkguy;

    Optreden willyLive;
    Optreden vijanden;
    Optreden xonk;
    Optreden xonk2;
    Optreden pink;

    @Before
    public void setup(){

        willy = new Artiest("Willy Somers", 2000);
        willy2 = new Artiest("Willy Somers", 2000);

        xink = new Artiest("X!NK", 1000000);
        vijandvechters = new Artiest("De Vijand Vechters", 20);
        pinkguy = new Artiest("Pink Guy", 2124);

        willyLive = new Optreden(willy, LocalTime.of(22, 00), 20);
        vijanden = new Optreden(vijandvechters, LocalTime.of(10, 00), 1);
        xonk = new Optreden(xink, LocalTime.of(23, 23), 1234);
        xonk2 = new Optreden(xink, LocalTime.of(23, 23), 1234);
        pink = new Optreden(pinkguy, LocalTime.of(12,12));


    }


    @Test
    public void equals_bij_gelijke_optredens_werkt(){
        Assert.assertEquals(xonk, xonk2);
    }

    @Test
    public void equals_geeft_false_bij_verschillende_objecten(){
        Assert.assertNotSame(xonk, willyLive);
    }
    @Test
    public void test_connstroctor_goed(){
        Artiest piemel = new Artiest("piemel", 12345);
        Optreden piemelsLive = new Optreden(piemel, LocalTime.of(23, 43));

        Assert.assertEquals(piemelsLive.getArtiest() , piemel);
        Assert.assertEquals(piemelsLive.getTicketPrijs(), 0);
        Assert.assertEquals(piemelsLive.getUur(), LocalTime.of(23, 43));

    }
    @Test
    public void test_connstroctor2_goed(){
        Artiest piemel = new Artiest("piemel", 12345);
        Optreden piemelsLive = new Optreden(piemel, LocalTime.of(23, 43), 123);

        Assert.assertEquals(piemelsLive.getArtiest() , piemel);
        Assert.assertEquals(piemelsLive.getTicketPrijs(), 123);
        Assert.assertEquals(piemelsLive.getUur(), LocalTime.of(23, 43));

    }

    @Test(expected = IllegalArgumentException.class)
    public void fout_constroctor(){
        Artiest piemel = new Artiest("piemel", 12345);
        Optreden piemelsLive = new Optreden(piemel, LocalTime.of(23, 43), -123);
    }
    @Test(expected = IllegalArgumentException.class)
    public void fout_constroctor_waarde_is_null(){
        Artiest piemel = new Artiest("piemel", 12345);
        Optreden piemelsLive = new Optreden(null, LocalTime.of(23, 43), 123);
    }

}
