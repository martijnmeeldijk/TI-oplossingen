package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void contactenMetZelfdeGegevensZijnGelijk() {
        Contact contact1 = new Contact("Janssen","Jan,","0123456789");
        Contact contact2 = new Contact("Janssen","Jan,","0123456789");
        assertEquals(contact1,contact2);
        assertEquals(contact1,contact1.clone());
    }

    @Test
    public void contactenMetVerschillendeGegevensZijnVerschillend() {
        Contact contact1 = new Contact("Janssen","Jan,","0123456789");
        Contact contact2 = new Contact("Janssens","Jan,","0123456789");
        assertNotSame(contact1,contact2);
    }

    @Test
    public void gelijkeContactenHebbenZelfdeHashcode() {
        Contact contact1 = new Contact("Janssen","Jan,","0123456789");
        Contact contact2 = new Contact("Janssen","Jan,","0123456789");
        assertEquals(contact1.hashCode(),contact2.hashCode());
    }
}