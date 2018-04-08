package ca.coursePlanner.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class is a data collection that stores all the Course by parsing a provided csv file.
 */
public class TopicCollection implements Comparator<Course> {

    private List<Course> csvCourseList = new ArrayList<>();
    //private List<Offering> allCourseOfferings = new ArrayList<>();
    private List<Topic> topicList = new ArrayList<>();

    private static TopicCollection instance = null;

    public static TopicCollection getInstance() throws FileNotFoundException {
        if (instance == null) {
            CSVReader.read();
            instance = new TopicCollection();
            instance.populateTopicList();
        }
        return instance;
    }

    public void displayTopicList() {
        populateTopicList();
        for (Topic aTopicList : topicList) {
            aTopicList.displayCourseTopic();
        }
    }

    private void populateTopicList() {
        Topic topic = new Topic();

        for (int i = 0; i < csvCourseList.size(); i++) {
            //for the last element
            if (i == csvCourseList.size() - 1) {
                //incase the last element doesnt bvelong to the previous block
                if (!topic.getSubject().equals(csvCourseList.get(i).getSubject()) ||
                        !topic.getCatalogNumber().equals(csvCourseList.get(i).getCatalogNumber())) {
                    topic = new Topic(csvCourseList.get(i).getSubject(), csvCourseList.get(i).getCatalogNumber());
                    topic.addToOffer(csvCourseList.get(i));
                    topicList.add(topic);
                    return;
                }
                //else manually add last element to the latest block, and add topic to the list manually
                topic.addToOffer(csvCourseList.get(i));
                topicList.add(topic);
                return;
            }
            if (topic.addToOffer(csvCourseList.get(i)))
                continue;
            else {
                if (i > 0)
                    topicList.add(topic);
                topic = new Topic(csvCourseList.get(i).getSubject(), csvCourseList.get(i).getCatalogNumber());
                topic.addToOffer(csvCourseList.get(i));
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
    public int compare(Course o1, Course o2) {

        int value1 = o1.getSubject().compareTo(o2.getSubject());
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

    public List<Course> getCsvCourseList() {
        return csvCourseList;
    }

    public void setCsvCourseList(List<Course> csvCourseList) {
        instance.csvCourseList = csvCourseList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }
}
