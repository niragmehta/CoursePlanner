package ca.coursePlanner.model;

import java.io.FileNotFoundException;

public class Facade {

    public static void writeDump() throws FileNotFoundException {

        String path="data/course_data_2018.csv";

        CSVReader csvReader = new CSVReader();
        CourseCollection courseCollectionInstance = CourseCollection.getInstance();

        csvReader.read(path);
        courseCollectionInstance.printDebug();
        courseCollectionInstance.displayTopicList();

        TxtWriter txtWriter=TxtWriter.getInstance();
        txtWriter.write();

    }

}
