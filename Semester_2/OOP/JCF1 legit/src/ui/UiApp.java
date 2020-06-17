package ui;

import db.OpdrachtDatabank;
import domain.Opdracht;

import domain.Quiz;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class UiApp {
    private Quiz quiz;
    private OpdrachtDatabank db;

    private Text menuText, uitvoerVeld;
    private TextField invoerVeld;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public UiApp(GridPane root) {

        db = new OpdrachtDatabank("Opdrachten-1.txt");
        quiz = new Quiz(db.getOpdrachten());

        uitvoerVeld = new Text();
        menuText = new Text(geefMenu());
        root.add(menuText, 0, 0);
        invoerVeld = new TextField("1");
        root.add(invoerVeld, 0, 1);
        root.add(uitvoerVeld,0,2);

        invoerVeld.setOnAction(eventInvoerVeld -> {
            uitvoerVeld.setText("");
            try {
                behandelKeuze(Integer.parseInt(invoerVeld.getText()), root);
                invoerVeld.clear();
            } catch (NumberFormatException e){
                invoerVeld.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("keuze moet een numeriek getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }

    private void behandelKeuze(int keuze, GridPane root){
            invoerVeld.setVisible(false);
            if (keuze >= 1 && keuze <= 5) {
                nieuweVraag("" + Opdracht.CATEGORIEEN[keuze-1], root);
            }
            else if (keuze == 6) {
                voegVraagToe(root);
            }
            else if (keuze == 7) {
                toonAlleVragen();
            }
            else if (keuze == 0) System.exit(0);
            else {
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("ongeldige keuze");
                foutenboodschap.showAndWait();
                invoerVeld.setVisible(true);
            }
    }

    private static String geefMenu() {
        String menu = "Kies hieronder de categorie voor je nieuwe vraag:\n";
        for(int i = 0; i< Opdracht.CATEGORIEEN.length; i++) {
            menu += "\n" + (i+1) + ". Categorie " + Opdracht.CATEGORIEEN[i];
        }
        menu += "\n\nAls je een nieuwe vraag wil toevoegen, kies dan 6.";
        menu += "\nVoor een overzicht van alle vragen, kies 7.";
        menu += "\n\t--> check hiervoor het output venster!";
        menu += "\n\nOm te stoppen, kies 0.";
        return menu;
    }

    private void nieuweVraag(String categorie, GridPane root) {
        Opdracht o = null;
        for(int i = 0 ; i < quiz.getOpdrachten().size() && o == null; i++) {
            if(quiz.getOpdrachten().get(i).getCategorie().equals(categorie))
                o =  quiz.getOpdrachten().get(i);
        }

        if (o != null){

            Opdracht finalO = o;
            Label nieuweVraagLabel = new Label("Geef het antwoord op de volgende vraag:\n" + finalO.getVraag() +
                    (finalO.isHoofdletterGevoelig() ? "\n(Antwoord is hoofdlettergevoelig!)" : "") +
                    (finalO.getAntwoordHint()!=null ? ("\nHINT: " + o.getAntwoordHint()) : ""));
            root.add(nieuweVraagLabel,0,3);
            TextField invoerAntwoord = new TextField();
            root.add(invoerAntwoord,0,4);

            quiz.getOpdrachten().remove(finalO);

            invoerAntwoord.setOnAction(eventInvoerAntwoord -> {
                String antwoord = invoerAntwoord.getText();

                if (checkJuisteAntwoord(antwoord, finalO.getAntwoord(), finalO.isHoofdletterGevoelig()))
                    uitvoerVeld.setText("Proficiat, juist geantwoord!");
                else
                    uitvoerVeld.setText("Helaas, dat was  een fout antwoord.\n\nHet juiste antwoord was: "
                            + finalO.getAntwoord());

                root.getChildren().removeAll(nieuweVraagLabel,invoerAntwoord);
                invoerVeld.setVisible(true);
            });


        } else {
            uitvoerVeld.setText("Er is geen vraag meer van deze categorie");
            invoerVeld.setVisible(true);
        }
    }

    private boolean checkJuisteAntwoord(String antwoord, String antwoordJuist, boolean isHoofdletterGevoelig) {
        if(!isHoofdletterGevoelig)
            return antwoord.equalsIgnoreCase(antwoordJuist);
        else
            return antwoord.equals(antwoordJuist);
    }

    public void voegVraagToe(GridPane root) {
        Label labelId = new Label("Geef de id van de nieuwe opdracht");
        root.add(labelId,0,3);
        TextField invoerId = new TextField();
        root.add(invoerId,1,3);

        Label labelCategorie = new Label("Geef de categorie van de nieuwe opdracht");
        TextField invoerCategorie = new TextField();

        Label labelVraag = new Label("Geef de vraag van de nieuwe opdracht");
        TextField invoerVraag = new TextField();

        Label labelAntwoord = new Label("Geef het antwoord van de nieuwe opdracht");
        TextField invoerAntwoord = new TextField();

        Label labelIsHoofdLetterGevoelig = new Label("Is de nieuwe opdracht hoofdlettergevoelig (true/false");
        TextField invoerIsHoofdLetterGevoeldig = new TextField();

        Label labelHint = new Label("Geef de hint voor de nieuwe opdracht");
        TextField invoerHint = new TextField();

        Label labelNaam = new Label("Geef de naam van de auteur van de nieuwe opdracht");
        TextField invoerNaam = new TextField();


        invoerId.setOnAction(eventInvoerId -> {
            try{
                Integer.parseInt(invoerId.getText());
                root.add(labelCategorie,0,4);
                root.add(invoerCategorie,1,4);
            }
            catch (NumberFormatException e){
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("id van de nieuwe vraag moet numeriek zijn");
                foutenboodschap.showAndWait();
                invoerId.clear();
            }

        });

        invoerCategorie.setOnAction(eventInvoerCategorie -> {
            root.add(labelVraag,0,5);
            root.add(invoerVraag,1,5);
        });

        invoerVraag.setOnAction(eventInvoerVraag -> {
            root.add(labelAntwoord,0,6);
            root.add(invoerAntwoord,1,6);
        });

        invoerAntwoord.setOnAction(eventInvoerAntwoord -> {
            root.add(labelIsHoofdLetterGevoelig,0,7);
            root.add(invoerIsHoofdLetterGevoeldig,1,7);
        });

        invoerIsHoofdLetterGevoeldig.setOnAction(eventInvoerIsHoofdLetterGevoelig -> {
            root.add(labelHint,0,8);
            root.add(invoerHint,1,8);
        });

        invoerHint.setOnAction(eventInvoerHint -> {
            root.add(labelNaam,0,9);
            root.add(invoerNaam,1,9);
        });

        invoerNaam.setOnAction( eventInvoerVolledig -> {
            int id = Integer.parseInt(invoerId.getText());
            String categorie = invoerCategorie.getText();
            String vraag = invoerVraag.getText();
            String antwoord = invoerAntwoord.getText();
            boolean hoofdletter = Boolean.parseBoolean(invoerIsHoofdLetterGevoeldig.getText());
            String hint = invoerHint.getText();
            String naam = invoerNaam.getText();

            Opdracht opdracht = new Opdracht(id, vraag, antwoord, hoofdletter, hint, categorie, naam);
            db.voegToe(opdracht);
            root.getChildren().removeAll(invoerId,labelId,invoerCategorie,labelCategorie,invoerVraag,labelVraag,invoerAntwoord,labelAntwoord,invoerIsHoofdLetterGevoeldig,labelIsHoofdLetterGevoelig,invoerHint,labelHint,invoerNaam,labelNaam);
            uitvoerVeld.setText("opdracht toegevoegd");
            invoerVeld.setVisible(true);
        });

    }

    private void toonAlleVragen() {
        System.out.println(quiz.toString());
        invoerVeld.setVisible(true);
    }

}
