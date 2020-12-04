package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {

    @FXML
    private ChoiceBox<String> imageChoiceBox;

    @FXML
    private TextField imageNameTextField;

    @FXML
    private Button showImageButton;

    @FXML
    private ImageView imageView;

    @FXML
    private Button logButton;

    @FXML
    private Button clearLogButton;

    @FXML
    private Button addImageButton;

    @FXML
    private Label chosen;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label errorMessage;

    @FXML
    private TextArea showLogTextArea;

    @FXML
    void chooseImage(MouseEvent event) {
    }

    @FXML
    void showImage(ActionEvent event) throws IOException{
        //removes log
        showLogTextArea.setOpacity(0);

        //console log of events
        String image = (String)imageChoiceBox.getValue();

        try{
            if(!image.isEmpty() || !image.isBlank()){
                errorMessage.setOpacity(0);
                String image1 = image + ".jpg";
                imageNameTextField.setText(image1);
                Image imageCurrent = new Image("/sample/img/"+image1);
                imageView.setImage(imageCurrent);

                //saves the log
                LogData logdata = new LogData();
                logdata.image1 = image1;
                Filehandling filehandling = new Filehandling();
                filehandling.saveData(logdata);
            }
        }
        catch(NullPointerException e){
            System.out.println("Error: no image selected");
            errorMessage.setOpacity(1);
        }
    }

    @FXML //loadData()
    void showLog(ActionEvent event) throws IOException {
        showLogTextArea.setOpacity(1);
        Filehandling filehandling = new Filehandling();
        String logdata;
        logdata = filehandling.loadData();
        showLogTextArea.appendText(logdata);

        // if log is cleared
        // show the cleared imagelog.txt
    }

    //TODO - change the GUI to match the new imagelog.txt
    @FXML
    void clearLog(ActionEvent event) throws IOException {
        Filehandling filehandling = new Filehandling();
        filehandling.removeLog("imageLog.txt");
    }



    //add new image from img folder to the photo album
    @FXML
    void addImage(ActionEvent event) {
        Label chosen = new Label();
/*        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file dialog");
*/

        Stage stage = (Stage)anchorPane.getScene().getWindow();
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            String fileAsString = file.toString();
            chosen.setText("Chosen: " + fileAsString);
            Path p = Paths.get(fileAsString);
            String addedimageName = p.getFileName().toString();

            //removes the .jpg from filepath
            if (addedimageName.indexOf(".") > 0)
                addedimageName = addedimageName.substring(0, addedimageName.lastIndexOf("."));

            imageChoiceBox.getItems().add(addedimageName);

        } else {
            chosen.setText(null);
        }

//      imageChoiceBox.getItems().add("fileName");


    }
}