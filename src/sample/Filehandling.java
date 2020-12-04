/*
 *
 * Developed by Sara Sandager (sara590x@edu.easj.dk)
 * Licensed under the MIT License
 * 03/12/2020
 *
 */

package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Filehandling {
    public void saveData(LogData logData) throws java.io.IOException {
        java.io.File file = new java.io.File("imagelog.txt");
        java.io.FileWriter output = new java.io.FileWriter(file, true); //Create a file using FileWriter (to append instead of override the log).

        //write formatted output to the file
        output.append("\n" + logData.dateTime + " ---> " + logData.image1);

        //close the file
        output.close();
    }

    public String loadData() throws FileNotFoundException {
        java.io.File file = new java.io.File("imagelog.txt");
        Scanner input = new Scanner(file); //Create a Scanner for the file

        //Read data from a file
        String completeLog = "";

        //all lines from .txt to completeLog
        while(input.hasNext()){
            completeLog+=input.nextLine() + "\n";
        }

        //Close the file
        return completeLog;
    }
    public void removeLog(String filepath) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("imagelog.txt");
        output.print("");
        output.close();
    }
}



