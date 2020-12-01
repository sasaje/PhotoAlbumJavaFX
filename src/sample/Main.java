package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        ChoiceBox imageChoiceBox = new ChoiceBox();

        //TODO set default value to "-- Select image --".
        imageChoiceBox.getItems().add("Elephant");
        imageChoiceBox.getItems().add("Giraffe");
        imageChoiceBox.getItems().add("Lion");
        imageChoiceBox.getItems().add("Hippo");
        imageChoiceBox.getItems().add("Rhino");

        Parent root = FXMLLoader.load(getClass().getResource("/sample/photoAlbumGui.fxml"));
        primaryStage.setTitle("Photo Album");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
