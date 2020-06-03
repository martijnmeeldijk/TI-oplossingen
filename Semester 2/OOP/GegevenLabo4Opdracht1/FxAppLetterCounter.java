package ui.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ui.view.LetterCounterApp;

import static javafx.application.Application.launch;


public class FxAppLetterCounter extends Application {
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(FxAppLetterCounter.class.getResource("lettercounter.css").toExternalForm());
        new LetterCounterApp(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Count occurence of letter in word");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}