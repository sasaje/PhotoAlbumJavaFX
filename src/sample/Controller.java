package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.*;

import static sample.Filehandling.clickCounter;

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
//                logDataNewSave.image = fileName;
                logdata.image1 = showLogTextArea.getText();
                Filehandling filehandling = new Filehandling();
                filehandling.saveData(logdata);
            }
        }
        catch(NullPointerException e){
            System.out.println("Error: no image selected");
            errorMessage.setOpacity(1);
        }
    }

    //TODO open .txt. when clicked on button showLog
    @FXML //load()
    void showLog(ActionEvent event) throws IOException {
        showLogTextArea.setOpacity(1);
        Filehandling filehandling = new Filehandling();
        LogData logdata;
        logdata = filehandling.loadData();
        showLogTextArea.setText(logdata.image1);
        showLogTextArea.appendText("Hello");
    }

    @FXML
    void addEventToLog(ActionEvent event) throws IOException {
        System.out.print(" addEventToLog: showImageButton clicked! ");
        System.out.print("clickCounter: " + clickCounter);
        clickCounter++;
        System.out.print(" clickCounter++: " + clickCounter + " ");
    }
}