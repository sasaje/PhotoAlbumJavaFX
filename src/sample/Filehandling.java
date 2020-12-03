/*
 *
 * Developed by Sara Sandager (sara590x@edu.easj.dk)
 * Licensed under the MIT License
 * 03/12/2020
 *
 */

package sample;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filehandling {
    public static int clickCounter = 0;

    public void saveData(LogData logData) throws java.io.IOException {
        java.io.File file = new java.io.File("imagelog.txt");
        java.io.PrintWriter output = new java.io.PrintWriter(file); //Create a file

        // TODO this must be repeated every time the imageShowButton is clicked. - it shows the log for the recent image
        //write formatted output to the file
        for (int i = 1; i < clickCounter; i++) {
            output.println(logData.dateTime + " ---> Shows test " + logData.image1);
        }
        output.println(logData.dateTime + " ---> Shows test " + logData.image1);

        //close the file
        output.close();
    }

    public LogData loadData() throws FileNotFoundException {
        java.io.File file = new java.io.File("imagelog.txt");
        Scanner input = new Scanner(file); //Create a Scanner for the file

        //Read data from a file
        LogData logData = new LogData();
//        String imageName = (String)Controller.getImageChoiceBox().getValue();
        logData.image1 = input.next();
//        logData.dateTime = input.next();
//        System.out.println(d + " ---> Shows " + imageName);

/*        while(input.hasNext()) {
            String imageName = (String) imageChoiceBox.getValue();
            Date d = new Date();
            System.out.println(d + " ---> Shows " + imageName);
        }
 */
        //Close the file
        return logData;
    }

}
