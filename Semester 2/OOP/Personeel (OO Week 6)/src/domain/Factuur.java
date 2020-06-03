package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Factuur implements IsBetaalbaar {
    int nummer;
    int maand;
    int jaar;

    Factuurlijn[] factuurlijnen;

    public Factuur(int nummer, int maand, int jaar, Factuurlijn ... factuurlijnen) {
        this.nummer = nummer;
        this.maand = maand;
        this.jaar = jaar;
        this.factuurlijnen = factuurlijnen;
    }

    @Override
    public double getBedrag(int maand, int jaar) {
        double totaal = 0;
        for(Factuurlijn f : factuurlijnen){
            totaal += f.getTotaalprijs();
        }
        return totaal;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }
}
