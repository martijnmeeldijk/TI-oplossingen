package ui.view;

import domain.model.LetterCounter;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LetterCounterApp {
    private final LetterCounter letterCounter = new LetterCounter();

    private final Label wordLabel = new Label("Word");
    private final TextField wordField = new TextField();

    private final Label letterLabel = new Label("Letter");
    private final TextField letterField = new TextField();

    private final Text resultText = new Text();

    private final Button countButton = new Button("Count this letter");

    private final Button quitButton = new Button("Quit");

    public LetterCounterApp(GridPane root) {

        //setting up grid
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setVgap(10);
        root.setHgap(10);

        customExitButton(quitButton);


        //adding event
        countButton.setOnAction(event -> {
			// to be implemented
        });

        // putting components on gridpane
        root.addRow(0,wordLabel);
        root.addRow(1,wordField);
        root.addRow(3,letterLabel);
        root.addRow(4,letterField);
        root.addRow(6,countButton);
        root.add(resultText,0,8);
        root.add(quitButton,0,10);
    }



    private void customExitButton(Button quitButton) {
        // add event to button quit
        quitButton.setOnAction(event ->
                Platform.exit()
        );
    }


}
