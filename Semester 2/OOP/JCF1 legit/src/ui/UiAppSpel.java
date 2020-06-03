package ui;

import db.OpdrachtDatabank;
import domain.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Set;

public class UiAppSpel {
    private SpelerGroep spelers;
    private Quiz quiz;
    private OpdrachtDatabank db;
    private Spel spel;
    private int aantalSpelers;

    //TODO foutafhandeling toevoegen

    public UiAppSpel(GridPane root) {
        spelers = new SpelerGroep();
        start(root);
    }

    private void start(GridPane root){
        Label aantalSpelersLabel = new Label("Hoeveel spelers zijn er?");
        root.add(aantalSpelersLabel,0,3);
        TextField aantalSpelersInvoer = new TextField();
        root.add(aantalSpelersInvoer,1,3);
        aantalSpelersInvoer.setOnAction(eventAantalSpelersInvoer -> {
            this.aantalSpelers = Integer.parseInt(aantalSpelersInvoer.getText());
            root.getChildren().removeAll(aantalSpelersLabel, aantalSpelersInvoer);
            addSpelers(1, root);
        });
    }

    private void addSpelers(int nr, GridPane root) {
        Label spelerNaamLabel = new Label("Geef de naam van speler " + nr + ":");
        root.add(spelerNaamLabel, 0, 3);
        TextField invoerNaam = new TextField();
        root.add(invoerNaam, 1, 3);
        invoerNaam.setOnAction(eventInvoerNaam1 -> {
            spelers.registreer(invoerNaam.getText());
            root.getChildren().removeAll(spelerNaamLabel, invoerNaam);
            if (nr < aantalSpelers) {
                addSpelers(nr + 1, root);
            }
            else{
                db = new OpdrachtDatabank("Opdrachten-1.txt");
                quiz = new Quiz(db.getOpdrachten());
                spel = new Spel(spelers, quiz);
                speel(root);
            }
        });
    }

    private void speel(GridPane root){
        Label labelSpeler = new Label("Vraag voor " + spel.getNaamSpelerAanBeurt() + ":");
        root.add(labelSpeler, 0, 3);
        Label labelVraag = new Label(spel.getVolgendeVraag());
        root.add(labelVraag, 0, 4);
        TextField antwoord = new TextField();
        root.add(antwoord, 0, 5);
        antwoord.setOnAction(eventAntwoord -> {
            //juiste antwoord opvragen voor er gespeeld wordt, want tijdens speel() wordt vraag verwijderd uit quiz
            Label juisteAntwoord = new Label("Het juiste antwoord was: " + quiz.getOpdracht(spel.getVraagIndex()).getAntwoord());
            root.getChildren().removeAll(labelSpeler, labelVraag, antwoord);
            boolean juist = spel.speel(antwoord.getText());
            Label resultaat = new Label(juist ? "Juist!" : "Fout");
            root.add(resultaat,0,1);
            if(!juist) root.add(juisteAntwoord,0,2);
            Button volgendeVraag = new Button("Volgende vraag");
            root.add(volgendeVraag,0,3);
            volgendeVraag.setOnAction(eventVolgendeVraag -> {
                root.getChildren().removeAll(resultaat,juisteAntwoord,volgendeVraag);
                if(!spel.isVoorbij()){
                    speel(root);
                }
                else{
                    toonWinnaars(root);
                }
            });
        });
    }

    private void toonWinnaar(GridPane root){
        Label done = new Label("Gedaan! De winnaar is " + spel.getWinnaar().getNaam()
                + " met " + spel.getHoogstePunt() + " punten.");
        root.add(done, 0,3);
    }

    private void toonWinnaars(GridPane root){
        Set<Speler> winnaars = spel.getWinnaars();
        String tekst = "Gedaan! De winnaar"
                + (winnaars.size()==1 ? " is" : "s zijn");
        for(Speler s : winnaars){
            tekst += "\n\t" + s.getNaam();
        }
        tekst += "\nmet " + spel.getHoogstePunt() + " punten.";
        Label done = new Label(tekst);
        root.add(done, 0,3);
    }

}