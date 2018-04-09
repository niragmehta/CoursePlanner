package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class is a data collection that stores all the csvCourseUnit by parsing a provided csv file.
 */
public class TopicCollection implements Comparator<csvCourseUnit> {

    List<csvCourseUnit> csvCsvCourseUnitList = new ArrayList<>();
    //private List<CourseByCampus> allCourseOfferings = new ArrayList<>();
    List<Topic> topicList = new ArrayList<>();

    private static TopicCollection instance = null;

    public static TopicCollection getInstance() {
        if (instance == null)
            instance = new TopicCollection();
        return instance;
    }

    public void displayTopicList() {
        populateTopicList();
        for (int i = 0; i < topicList.size(); i++) {
            topicList.get(i).displayCourseTopic();
        }
    }

    public void populateTopicList() {
        Topic topic = new Topic();
        topicList=new ArrayList<>();


        for (int i = 0; i < csvCsvCourseUnitList.size(); i++) {
            //for the last element
            if (i == csvCsvCourseUnitList.size() - 1) {
                //incase the last element doesnt bvelong to the previous block
                if (!topic.getSubject().equals(csvCsvCourseUnitList.get(i).getSubjectName()) ||
                        !topic.getCatalogNumber().equals(csvCsvCourseUnitList.get(i).getCatalogNumber())) {
                    topic = new Topic(csvCsvCourseUnitList.get(i).getSubjectName(), csvCsvCourseUnitList.get(i).getCatalogNumber());
                    topic.addToOffer(csvCsvCourseUnitList.get(i));
                    topicList.add(topic);
                    return;
                }
                //else manually add last element to the latest block, and add topic to the list manually
                topic.addToOffer(csvCsvCourseUnitList.get(i));
                topicList.add(topic);
                return;
            }
            if (topic.addToOffer(csvCsvCourseUnitList.get(i)))
                continue;
            else {
                if (i > 0)
                    topicList.add(topic);
                topic = new Topic(csvCsvCourseUnitList.get(i).getSubjectName(), csvCsvCourseUnitList.get(i).getCatalogNumber());
                topic.addToOffer(csvCsvCourseUnitList.get(i));
            }
        }
    }


    public void printDebug() {
        populateTopicList();
        for (Topic aTopicList : topicList) {
            System.out.println(aTopicList.toString());
        }
    }

    @Override
    public int compare(csvCourseUnit o1, csvCourseUnit o2) {

        int value1 = o1.getSubjectName().compareTo(o2.getSubjectName());
        if (value1 == 0) {
            int value2 = o1.getCatalogNumber().compareTo(o2.getCatalogNumber());
            if (value2 == 0) {
                String o1Semester = Integer.toString(o1.getSemester());
                String o2Semster = Integer.toString(o2.getSemester());
                int value3 = o1Semester.compareTo(o2Semster);
                if (value3 == 0) {
                    int value4 = o1.getLocation().compareTo(o2.getLocation());
                    return value4;

                }
                return value3;
            } else
                return value2;

        } else
            return value1;
    }


    public List<csvCourseUnit> getCsvCsvCourseUnitList() {
        return csvCsvCourseUnitList;
    }

    public void setCsvCsvCourseUnitList(List<csvCourseUnit> csvCsvCourseUnitList) {
        instance.csvCsvCourseUnitList = csvCsvCourseUnitList;
    }

    public List<Topic> getTopicList() {
        populateTopicList();
        return topicList;
    }
}
