package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
    private Button removeImageButton;

    @FXML
    private Label chooseImage;

    @FXML
    private Label chosen;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label errorMessage;

    @FXML
    private TextArea showLogTextArea;

    @FXML
    void chooseImage(){

    }

    @FXML
    void showImage(ActionEvent event) throws IOException{
        chosen.setOpacity(0); // remove the newly added image path from top label chosen
        showLogTextArea.setOpacity(0); // removes log

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

    @FXML
    void clearLog(ActionEvent event) throws IOException {
        Filehandling filehandling = new Filehandling();
        filehandling.removeLog("imageLog.txt");

        //TODO - update the GUI to match the new empty imagelog.txt
        // it works in .txt
    }

    //add new image from img folder to the photo album
    //TODO when image added show Image
    @FXML
    void addImage(ActionEvent event) {

        Stage stage = (Stage)anchorPane.getScene().getWindow();
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(stage);
        if (file != null) {

            String fileAsString = file.toString();
            chosen.setOpacity(1);
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

        //TODO call show image on this newly added image
    }

    //TODO remove Image from album permanent also when program closes
    @FXML
    void removeImage(ActionEvent event){
        String imageToRemove = (String)imageChoiceBox.getValue();
        imageChoiceBox.getItems().remove(imageToRemove);

        //removes image from imageView and the imageTitle from imageNameTextField
        imageView.setImage(null);
        imageNameTextField.setText("");
    }
}