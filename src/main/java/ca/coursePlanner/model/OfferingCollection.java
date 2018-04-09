package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OfferingCollection {

    private static List<Offering> offeringList=new ArrayList<>();


    public static void populateList(int deptId,int courseId)
    {
        offeringList=new ArrayList<>();

        String deptName=DepartmentCollection.getDepartmentById(deptId).getName();
        String catalogNumber=CourseCollection.getCourseById(courseId).getCatalogNumber();

        AtomicInteger atomicInteger=new AtomicInteger();

        List<Topic> topicList=TopicCollection.getInstance().getTopicList();
        for(int i=0;i<topicList.size();i++)
        {

            if(deptName.equals(topicList.get(i).getSubject()) && catalogNumber.equals(topicList.get(i).getCatalogNumber()))
            {
                List<OfferingLocationCampus> list=topicList.get(i).getCoursesOfferList();

                Offering offering=new Offering();
                for(int j=0;j<list.size();j++)
                {
                    int semester=list.get(j).getSemester();
                    int year=getYear(semester);
                    String term=getTerm(semester);
                    String instructors=OfferingLocationCampus.getInstructors();
                    Course course=CourseCollection.getCourseById(courseId);

                    offering.setCourseOfferingId(atomicInteger.incrementAndGet());
                    offering.setLocation(list.get(j).getLocation());
                    offering.setSemesterCode(list.get(j).getSemester());
                    offering.setYear(year);
                    offering.setTerm(term);
                    offering.setInstructors(instructors);
                    offering.setCourse(course);


                    offeringList.add(offering);
                    offering=new Offering();
                }

            }
        }

    }
    private static int getYear(int semester)
    {
        int firstDigit=Integer.parseInt(Integer.toString(semester).substring(0,1));
        int midDigits=Integer.parseInt(Integer.toString(semester).substring(1,3));

        int year=1900+(100*firstDigit)+midDigits;

        return year;
    }
    private static String getTerm(int semester)
    {
        int termDigit=semester%10;
        String term="Fall";
        switch (termDigit)
        {
            case 1: {
                term="Spring";
                break;
            }
            case 4: {
                term="Summer";
                break;
            }
            case 7: {
                term = "Fall";
                break;
            }
            default:{
                System.out.print("Term not encoded correctly or not found");
            }
        }

        return term;


    }

    public static List<Offering> getOfferingList() {
        return offeringList;
    }
}
