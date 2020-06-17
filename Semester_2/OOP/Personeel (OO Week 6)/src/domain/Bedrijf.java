package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bedrijf implements Serializable {

    public Bedrijf(){

    }

    ArrayList<IsBetaalbaar> objecten = new ArrayList<>();

    public void voegToe(IsBetaalbaar b){
        objecten.add(b);
    }

    public void voegToe(IsBetaalbaar ... a){
        objecten.addAll(List.of(a));
    }

    public double kostenVanMaand(int maand, int jaar){
        double totaal = 0;
        for(IsBetaalbaar b : objecten){
            if(b instanceof Factuur) {
                if (b.getJaar() == jaar && b.getMaand() == maand) {
                    totaal += b.getBedrag(maand, jaar);
                }
            }
            if(b instanceof SalarisPersoneelslid){
                totaal += b.getBedrag(maand ,jaar);
            }
        }
        return totaal;
    }

    @Override
    public String toString(){
        return "";
    }


}
