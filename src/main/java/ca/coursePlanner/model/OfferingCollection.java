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
        Course course=CourseCollection.getCourseById(courseId);

        AtomicInteger atomicInteger=new AtomicInteger();

        List<Topic> topicList=TopicCollection.getInstance().getTopicList();
        for(int i=0;i<topicList.size();i++)
        {
            if(deptName.equals(topicList.get(i).getSubject()) && catalogNumber.equals(topicList.get(i).getCatalogNumber()))
            {
                List<CourseByCampus> list=topicList.get(i).getCoursesOfferList();

                Offering offering=new Offering();
                for(int j=0;j<list.size();j++)
                {
                    int semester=list.get(j).getSemester();
                    int year=getYear(semester);
                    String term=getTerm(semester);

                    list.get(j).PopulateEnrollmentTotal();

                    StringBuilder instructors=new StringBuilder();
                    List<String> instructorsList=list.get(j).getInstructors();
                    for(int t=0;t<instructorsList.size();t++) {
                        instructors.append(instructorsList.get(t));
                    }


                    offering.setCourseOfferingId(atomicInteger.incrementAndGet());
                    offering.setLocation(list.get(j).getLocation());
                    offering.setSemesterCode(list.get(j).getSemester());
                    offering.setYear(year);
                    offering.setTerm(term);
                    offering.setInstructors(instructors.toString());
                    offering.setCourse(course);

                    //addition fields not used by UI, but needed later
                    offering.setComponentCapacity(list.get(j).getComponentCapacity());
                    offering.setComponentTotal(list.get(j).getComponentTotal());
                    offering.setComponentType(list.get(j).getComponentType());

                    offeringList.add(offering);

                    offering=new Offering();
                }
                //we have stored all offerings into the list, now we can exit the loop

                course.setOfferingList(offeringList);
                return;
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

    public static Offering getOfferingById(int courseOfferingId)
    {
        Offering offering=new Offering();
        for(int i=0;i<offeringList.size();i++)
        {
            if(courseOfferingId==offeringList.get(i).getCourseOfferingId())
            {
                offering= offeringList.get(i);
            }
        }
        return offering;
    }

    public static List<Offering> getOfferingList() {
        return offeringList;
    }
}
