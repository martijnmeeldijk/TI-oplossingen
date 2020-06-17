package domain;

public class Tijdschrift extends Product {

    private int week;

    public Tijdschrift(String titel, double prijs, int week){
        super(titel, prijs);
        this.week = week;

    }

    @Override
    public String naarString(){
        return "| Week: " + week + " | " + super.naarString() ;
    }

    public int getWeek() {
        return week;
    }

    @Override
    public boolean equals(Object t) {
        if (super.equals(t) && t instanceof Tijdschrift) {
            Tijdschrift p = (Tijdschrift) t;
            return p.getWeek() == this.week && super.equals(t);
        }
        else return false;
    }
}
