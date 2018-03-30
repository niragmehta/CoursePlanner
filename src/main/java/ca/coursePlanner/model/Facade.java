package ca.coursePlanner.model;

import java.io.FileNotFoundException;

public class Facade {
    public static void main(String[] args) throws FileNotFoundException {



        CSVReader csvReader = new CSVReader();
        CourseCollection courseCollectionInstance = CourseCollection.getInstance();

        csvReader.read();
        courseCollectionInstance.printDebug();
        courseCollectionInstance.displayTopicList();

        TxtWriter txtWriter=TxtWriter.getInstance();
        txtWriter.write();

    }

}
