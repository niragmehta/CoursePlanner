package ca.coursePlanner.model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtWriter {

    static TxtWriter instance;
    private StringBuilder stringBuilder = new StringBuilder();
    private FileWriter fw;
    private BufferedWriter bw;

    public static TxtWriter getInstance()
    {
        if(instance==null)
            instance=new TxtWriter();
        return instance;
    }

    public void write() {
        try {

            String header  = "Model Dump from 'course_data_2018.csv' file\n\n";
            String content = stringBuilder.toString();
            File file = new  File("output_dump.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(header + content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString()
    {
        return stringBuilder.toString();
    }

    public void append(String string){
        stringBuilder.append(string);
    }

    public FileWriter getFw() {
        return fw;
    }

    public BufferedWriter getBw() {
        return bw;
    }
}
