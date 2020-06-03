package domain;

import java.util.ArrayList;

public class Personeel {


        private ArrayList<Personeelslid> personeel = new ArrayList<>();
        public Personeel(){

        }
        public void voegToe(Personeelslid p) {
            personeel.add(p);
        }
        public boolean werkt(String code, int aantalUren) {
            for(Personeelslid p : personeel){
                if(p.getCode() == code){
                    p.werk(aantalUren);
                    return true;
                }
            }
            return false;
        }
        public String betaal() {
            String result = "";
            for(Personeelslid p : personeel){
                result += p.getNaam() + " is €" + p.berekenLoon() + " betaald voor " + p.getUren() + "uur werk \n";
                p.setUren(0);
            }
            return result;
        }
        private Personeelslid zoekPersoneelslid(String code) {
            for(Personeelslid p : personeel){
                if(p.getCode() == code){
                    return p;
                }
            }
            throw new IllegalArgumentException("Personeelslid niet gevonden");
        }
        public String toString(){
            return "";
        }
    }

