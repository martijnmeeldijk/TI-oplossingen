package domain;

import java.time.LocalTime;

public class Rit {



    //SCOPE
    private LocalTime startTijdstip;
    private LocalTime eindTijdstip;
    private double geredenKm;


    //CONSTRUCTOR
    public Rit(){
        this.startTijdstip = LocalTime.now();
    }


    //METHODS
    public void stop(double aantalKm, LocalTime eindTijdstip){
        if(aantalKm == 0){
            throw new IllegalArgumentException("Je kan een rit niet stoppen als je 0km hebt gereden, dipshit");
        }
        this.eindTijdstip = eindTijdstip;
        this.geredenKm = aantalKm;
    }
    public boolean isGestopt(){
        return eindTijdstip != null;
    }



    //GETTERS
    public LocalTime getStartTijdstip() {
        return startTijdstip;
    }

    public LocalTime getEindTijdstip() {
        return eindTijdstip;
    }

    public double getAantalKm() {
        return geredenKm;
    }

    //SETTERS

    public void setStartTijdstip(LocalTime startTijdstip) {
        this.startTijdstip = startTijdstip;
    }

    public void setEindTijdstip(LocalTime eindTijdstip) {
        this.eindTijdstip = eindTijdstip;
    }

    public void setGeredenKm(double geredenKm) {
        this.geredenKm = geredenKm;
    }

}

/*- startTijdstip : LocalTime
- eindTijdstip : LocalTime
- geredenKm : double*/

/*
+ Rit()
        + stop(aantalKm:double, eindTijdstip:LocalTime)
        + isRitGestopt( ) :  boolean
        + berekenPrijs(tarieven : double[]) : double
        + stopRit()
        + aantalGeredenMinuten() : int
        + isGestartInPiekuur() : boolean
        + toString() : String*/
