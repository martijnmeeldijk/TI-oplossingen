package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoekTest {

    String titel = "Java for dummies";
    String auteur = "Barry A. Burd";
    int aantalPaginas = 290;
    double prijs = 38.99;


    // TEST CONSTRUCTOR STANDAARD

    @Test
    public void test_boek_standaardParameters(){
        Boek boek = new Boek(titel,auteur,aantalPaginas,prijs);
        assertEquals(titel,boek.getTitel());
        assertEquals(auteur,boek.getAuteur());
        assertEquals(aantalPaginas, boek.getAantalPaginas());
        assertEquals(prijs,boek.getPrijs(),0.001);
    }

    // TEST CONSTRUCTOR AANTALPAGINAS

    @Test(expected = DomainException.class)
    public void test_boek_aantalPaginas0_gooitException(){
        new Boek(titel,auteur,0,prijs);
    }

    @Test(expected = DomainException.class)
    public void test_boek_negatiefAantalPaginas_gooitException(){
        new Boek(titel,auteur,-5,prijs);
    }
}
