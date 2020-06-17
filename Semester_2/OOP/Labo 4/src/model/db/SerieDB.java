package model.db;

import model.domain.Serie;

import java.util.ArrayList;

public class SerieDB {


    ArrayList<Serie> serielijst = new ArrayList<>();

    private Serie MadMen = new Serie("Mad Men", 200, 30, 3);
    private Serie BlackMirror = new Serie("Black Mirror", 30, 50, 5);




    public SerieDB(){
        serielijst.add(MadMen);
        serielijst.add(BlackMirror);
    }

    public void addSerie(Serie s){
        serielijst.add(s);
    }

    public ArrayList<Serie> getSerielijst() {
        return serielijst;
    }
}
