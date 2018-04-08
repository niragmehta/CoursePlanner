package ca.coursePlanner.model;

import java.io.FileNotFoundException;

public class Facade {

    public static void writeDump() throws FileNotFoundException {

        String path="data/course_data_2018.csv";

        CSVReader csvReader = new CSVReader();
        TopicCollection topicCollectionInstance = TopicCollection.getInstance();

        csvReader.read();
        topicCollectionInstance.printDebug();
        topicCollectionInstance.displayTopicList();



        TxtWriter txtWriter=TxtWriter.getInstance();
        txtWriter.write();

    }

    public static void populateDepartmentList() throws FileNotFoundException {
        String path="data/course_data_2018.csv";
        //CSVReader csvReader = new CSVReader();
        TopicCollection topicCollectionInstance = TopicCollection.getInstance();
        //csvReader.read();

        DepartmentCollection instance=DepartmentCollection.getInstance();

    }

    public static void main(String[] args){

    }

}
