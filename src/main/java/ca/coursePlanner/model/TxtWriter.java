package ca.coursePlanner.model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtWriter {
    public static void write(String content) {
        try {

            String header  = "Model Dump from 'course_data_2018.csv' file\n";

            File file = new  File("C:/Users/Public/toDelete/dump.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(header + content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
