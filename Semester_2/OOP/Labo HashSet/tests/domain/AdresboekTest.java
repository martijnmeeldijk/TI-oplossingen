package domain;

import org.junit.Before;
import org.junit.Test;
//import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AdresboekTest {
    Adresboek adresboek, adresboek1, adresboek2;
    Contact contact1, contact2, contact3, contact4, contact5;
    Set<Contact> lijst1, lijst2;

    @Before
    public void setUp() {
        adresboek = new Adresboek();
        contact1 = new Contact("Janssens", "Jan", "0123456789");
        contact2 = new Contact("Pieters", "Piet", "0123456789");
        contact3 = new Contact("Somers", "Joris", "0123456789");
        contact4 = new Contact("Teugels", "Tim", "0123456789");
        contact5 = new Contact("Zegers", "Zeno", "0123456789");

        lijst1 = new HashSet<>();
        lijst1.add(contact1);
        lijst1.add(contact2);
        lijst1.add(contact3);

        lijst2=new HashSet<>();
        lijst2.add(contact4);
        lijst2.add(contact5);
        adresboek1 = new Adresboek(lijst1);
        adresboek2 = new Adresboek(lijst2);
    }

    @Test
    public void voegContactToeLegalCase() {
        assertTrue(adresboek.voegToe(contact1));
        assertEquals(1, adresboek.getContacten().size());
        assertTrue(adresboek.voegToe("Jansen", "Pieter", 123456));
        assertEquals(2, adresboek.getContacten().size());
    }

    @Test
    public void contactKanMaarEenKeerToegevoegdWorden() {
        assertTrue(adresboek.voegToe(contact1));
        assertEquals(1, adresboek.getAantalContacten());
        assertFalse(adresboek.voegToe((Contact) contact1.clone()));
        assertEquals(1, adresboek.getAantalContacten());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ongeldigContactToevoegenGooitFout() {
        adresboek.voegToe(null);
        adresboek.voegToe("", "", 0);
    }

    @Test
    public void gemeenschappelijkeContactenLegalCase() {
        // geen gemeenschappelijke contacten: leeg adresboek
        assertEquals(0, adresboek1.gemeenschappelijkeContacten(adresboek2).getAantalContacten());
        // alle contacten gemeenschappelijk bij zelfde adresboek
        assertEquals(3,adresboek1.gemeenschappelijkeContacten(adresboek1).getAantalContacten());
        // random case
        adresboek2.voegToe(contact1);
        adresboek2.voegToe(contact2);
        assertEquals(2, adresboek1.gemeenschappelijkeContacten(adresboek2).getAantalContacten());
        assertTrue(adresboek1.gemeenschappelijkeContacten(adresboek2).contains(contact1));
        assertTrue(adresboek1.gemeenschappelijkeContacten(adresboek2).contains(contact2));
        assertFalse(adresboek1.gemeenschappelijkeContacten(adresboek2).contains(contact3));
    }

    @Test
    public void gezamelijkeContactenLegalCase() {
        // twee disjuncte adresboeken
        assertEquals(5,adresboek1.gezamelijkeContacten(adresboek2).getAantalContacten());
        assertEquals(5,adresboek2.gezamelijkeContacten(adresboek1).getAantalContacten());
        // adresboeken bevatten twee gezamelijke contacten
        adresboek2.voegToe(contact1);
        adresboek2.voegToe(contact2);
        assertEquals(5, adresboek1.gezamelijkeContacten(adresboek2).getAantalContacten());
        assertEquals(5, adresboek2.gezamelijkeContacten(adresboek1).getAantalContacten());
        assertTrue(adresboek1.gezamelijkeContacten(adresboek2).contains(contact1));
        assertTrue(adresboek1.gezamelijkeContacten(adresboek2).contains(contact2));
        assertTrue(adresboek1.gezamelijkeContacten(adresboek2).contains(contact3));
    }

    @Test
    public void verschillendeContacten() {
        // twee disjunctie adresboeken
        assertEquals(3,adresboek1.verschillendeContacten(adresboek2).getAantalContacten());
        assertEquals(2,adresboek2.verschillendeContacten(adresboek1).getAantalContacten());
        // adresboeken bevatten twee gezamelijke contacten
        adresboek2.voegToe(contact1);
        adresboek2.voegToe(contact2);
        assertEquals(1, adresboek1.verschillendeContacten(adresboek2).getAantalContacten());
        assertEquals(2, adresboek2.verschillendeContacten(adresboek1).getAantalContacten());
        assertFalse(adresboek1.verschillendeContacten(adresboek2).contains(contact1));
        assertFalse(adresboek1.verschillendeContacten(adresboek2).contains(contact2));
        assertTrue(adresboek1.verschillendeContacten(adresboek2).contains(contact3));
    }
}