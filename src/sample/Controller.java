package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    int clickCounter = 0;

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
    void chooseImage(MouseEvent event) {
    }

    @FXML
    void showImage(ActionEvent event) throws IOException, NullPointerException{
        writeData();

        //console log of events
        String image = (String) imageChoiceBox.getValue();
        Date d = new Date();
        System.out.println(d + "---> Shows " + image);

        try{
            if(!image.isEmpty() || !image.isBlank()){
                errorMessage.setOpacity(0);
                String fileName = image + ".jpg";
                imageNameTextField.setText(fileName);
                Image imageCurrent = new Image("/sample/img/"+fileName);
                imageView.setImage(imageCurrent);
            }
        }
        catch(NullPointerException e){
            System.out.println("Error: no image selected");
            errorMessage.setOpacity(1);
        }
    }

    @FXML
    void showLog(MouseEvent event) throws java.io.IOException{
        readData(); // read imageLog.txt
    }

    @FXML
    void addEventToLog(MouseEvent event) throws IOException {
        System.out.println("ACTION: showImageButton clicked!");
        clickCounter++;
    }

    public void writeData() throws java.io.IOException {
        java.io.File file = new java.io.File("imageLog.txt");
/*        if(file.exists()) {
            System.out.println("File " + file + " already exists");
        }
*/
        //Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);

        // TODO this must be repeated every time the imageShowButton is clicked. - it shows the log for the recent image
        //write formatted output to the file

        for (int i = 0; i < clickCounter; i++) {
            output.println("Event added to imageLog.txt");
            Date dateLog = new Date();
            output.println(dateLog + " ---> Shows test " + (String) imageChoiceBox.getValue());
        }

        //close the file
        output.close();
    }

    public void readData() throws FileNotFoundException {
        java.io.File file = new java.io.File("/imageLog.txt");

        //Create a Scanner for the file
        Scanner input = new Scanner(file);

        //Read data from a file
        while(input.hasNext()) {
            String imageName = (String) imageChoiceBox.getValue();
            Date d = new Date();
            System.out.println(d + " ---> Shows " + imageName);
        }
        //Close the file
        input.close();
    }
}