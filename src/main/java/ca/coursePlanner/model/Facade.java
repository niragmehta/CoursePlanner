package ca.coursePlanner.model;

import java.io.FileNotFoundException;
import java.util.List;

public class Facade {

    public static void writeDump() throws FileNotFoundException {

        String path="data/course_data_2018.csv";

        CSVReader csvReader = new CSVReader();
        TopicCollection topicCollectionInstance = TopicCollection.getInstance();

        csvReader.read(path);
        topicCollectionInstance.printDebug();
        topicCollectionInstance.displayTopicList();

        TxtWriter txtWriter=TxtWriter.getInstance();
        txtWriter.write();

    }

    public static int getTotalCourseOfferingCount()
    {

        int count=0;
        List<Topic> topicList=TopicCollection.getInstance().getTopicList();
        for(int i=0;i<topicList.size();i++)
        {
            count+=topicList.get(i).getCoursesOfferList().size();
        }
        return count;
    }

}
