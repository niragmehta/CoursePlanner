package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseCollection implements Comparator<Course> {

    List<Course> csvCourseList = new ArrayList<>();
    //private List<CourseOffer> allCourseOfferings = new ArrayList<>();
    List<CourseTopic> topicList =new ArrayList<>();

    private static CourseCollection instance = null;

    public static CourseCollection getInstance() {
        if (instance == null)
            instance = new CourseCollection();
        return instance;
    }

    public void displayTopicList()
    {
        populateTopicList();
        for(int i=0;i<topicList.size();i++)
        {
            topicList.get(i).displayCourseTopic();
            //System.out.println();
        }
    }


    public void populateTopicList()
    {
        CourseTopic courseTopic=new CourseTopic();

        for(int i=0;i<csvCourseList.size();i++)
        {
            //for the last element
            if(i==csvCourseList.size()-1)
            {
                //incase the last element doesnt bvelong to the previous block
                if(!courseTopic.getSubject().equals(csvCourseList.get(i).getSubject()) ||
                        !courseTopic.getCatalogNumber().equals(csvCourseList.get(i).getCatalogNumber()))
                {
                    courseTopic=new CourseTopic(csvCourseList.get(i).getSubject(),csvCourseList.get(i).getCatalogNumber());
                    courseTopic.addToOffer(csvCourseList.get(i));
                    topicList.add(courseTopic);
                    return;
                }
                //else manually add last element to the latest block, and add courseTopic to the list manually
                courseTopic.addToOffer(csvCourseList.get(i));
                topicList.add(courseTopic);
                return;
            }

            if(courseTopic.addToOffer(csvCourseList.get(i)))
                continue;
            else
            {
                if(i>0)
                    topicList.add(courseTopic);

                courseTopic=new CourseTopic(csvCourseList.get(i).getSubject(),csvCourseList.get(i).getCatalogNumber());
                courseTopic.addToOffer(csvCourseList.get(i));
            }
        }
    }


    public void printDebug()
    {
        populateTopicList();
        for(int i=0;i<topicList.size();i++)
        {
            System.out.println(topicList.get(i).toString());
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

    public List<CourseTopic> getTopicList() {

        populateTopicList();
        return topicList;
    }
}
