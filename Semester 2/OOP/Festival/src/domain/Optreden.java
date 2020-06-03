package domain;

import java.time.LocalTime;

public class Optreden {
    LocalTime uur;
    double ticketPrijs;
    Artiest artiest;

    public Optreden( Artiest artiest, LocalTime uur, double ticketPrijs) {
        if(ticketPrijs < 0) throw new IllegalArgumentException("Ticketprijs mag niet negatief zijn");
        if(artiest == null || uur == null) throw new IllegalArgumentException("JE hebt iets niet ingevuld");
        this.uur = uur;
        this.ticketPrijs = ticketPrijs;
        this.artiest = artiest;
    }

    public Optreden(Artiest artiest, LocalTime uur) {
        this.uur = uur;
        this.artiest = artiest;
    }

    public Artiest getArtiest() {
        return artiest;
    }

    public LocalTime getUur() {
        return uur;
    }

    public double getTicketPrijs() {
        return ticketPrijs;
    }

    @Override
    public String toString() {
        return artiest.toString() + " Uur: " + uur.toString() + " Ticketprijs: " + ticketPrijs + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Optreden){
            Optreden o = (Optreden) obj;
            return o.artiest.equals(this.artiest) && o.uur.equals(this.uur) && o.ticketPrijs == this.ticketPrijs;
        }
        return false;
    }
}
