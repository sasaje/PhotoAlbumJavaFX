package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ChoiceBox imageChoiceBox = new ChoiceBox();

        //TODO set default value to "-- Select image --".
        imageChoiceBox.getItems().add("-- Select image --");
        imageChoiceBox.getItems().add("Elephant");
        imageChoiceBox.getItems().add("Giraffe");
        imageChoiceBox.getItems().add("Lion");
        imageChoiceBox.getItems().add("Hippo");
        imageChoiceBox.getItems().add("Rhino");


        Parent root = FXMLLoader.load(getClass().getResource("photoAlbumGui.fxml"));
        primaryStage.setTitle("Photo Album");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}