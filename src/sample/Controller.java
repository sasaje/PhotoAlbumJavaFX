package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.*;

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

    //TODO open .txt. when clicked on button showLog from loadData()
    @FXML //load()
    void showLog(ActionEvent event) throws IOException {
        showLogTextArea.setOpacity(1);
        Filehandling filehandling = new Filehandling();
        String logdata;
        logdata = filehandling.loadData();
        showLogTextArea.appendText(logdata);
    }
}