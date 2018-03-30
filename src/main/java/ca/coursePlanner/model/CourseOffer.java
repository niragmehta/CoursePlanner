package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class CourseOffer {

    private List<Course> courseList = new ArrayList<>();
    String subject;
    String catalogNumber;
    private String location;
    private int semester;

    List<String> componentType=new ArrayList<>();
    List<Integer> componentCapacity=new ArrayList<>();
    List<Integer> componentTotal=new ArrayList<>();
    List<String> instructors=new ArrayList<>();
    String instrcutorsStr;

    public CourseOffer(String location, int semester,String subject,String catalogNumber) {
        this.location = location;
        this.semester = semester;
        this.subject=subject;
        this.catalogNumber=catalogNumber;
    }

    public boolean addCourse(Course course){
        if(course.getLocation().equals(this.location) && course.getSemester() == this.semester
                && course.getSubject().equals(this.subject) && course.getCatalogNumber().equals(this.catalogNumber))
        {
            courseList.add(course);
            return true;
        }
        return false;
    }

    public void displayCourseOffer()
    {
        PopulateEnrollmentTotal();
        System.out.println("\t"+semester+" in "+location + " by "+instrcutorsStr+"\n");
        for(int i=0;i<componentType.size();i++)
        {
            System.out.println("\t\tTYPE="+componentType.get(i)+", Enrollment= "+componentTotal.get(i)+"/"+componentCapacity.get(i));
        }


    }

    public void PopulateEnrollmentTotal()
    {
        for(int i=0;i<courseList.size();i++)
        {
            if(!instructors.contains(courseList.get(i).getInstructor()))
                instructors.add(courseList.get(i).getInstructor());

            if(componentType.contains(courseList.get(i).getComponentCode()))
            {
                int index=componentType.indexOf(courseList.get(i).getComponentCode());
                int temp=componentCapacity.get(index)+courseList.get(i).getEnrolmentCapacity();
                componentCapacity.set(index,temp);
                temp=componentTotal.get(index)+courseList.get(i).getEnrolmentCapacity();
                componentTotal.set(index,temp);
            }
            else
            {
                componentType.add(courseList.get(i).getComponentCode());
                componentCapacity.add(courseList.get(i).getEnrolmentCapacity());
                componentTotal.add(courseList.get(i).getEnrolmentTotal());
            }
        }
        for(int i=0;i<instructors.size();i++)
            instrcutorsStr+=", "+instructors.get(i);

        instrcutorsStr.substring(1);
    }


    public List<Course> getCourseList() {
        return courseList;
    }

    public String getLocation() {
        return location;
    }

    public int getSemester() {
        return semester;
    }

    public String getSubject() {
        return subject;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }


    //    private String subject="";
//    private String catalogNumber="";
//    private int enrollmentCapacity;
//    private int semester;
//    private String location;
//
//    private int tutCapacity;
//    private int labCapacity;
//    private int lectureCapacity;
//    private int cnvCapacity;
//    private int oplCapacity;
//    private int insCapacity;
//    private int secCapacity;
//    private int stlCapacity;
//    private int praCapacity;
//    private int rqlCapacity;
//    private int semCapacity;

//    public CourseOffer( String subject, String catalogNumber,int enrollmentCapacity,int semester,String location) {
//        this.subject = subject;
//        this.catalogNumber = catalogNumber;
//        this.enrollmentCapacity=enrollmentCapacity;
//        this.semester=semester;
//        this.location=location;
//        calculateCapacity();
//    }
//    public void calculateCapacity()
//    {
//        for(int i=0;i<courseOffer.size();i++)
//        {
//            if(courseOffer.get(i).getComponentCode().equals("LEC"))
//            {
//                lectureCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("LAB"))
//            {
//                labCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("TUT"))
//            {
//                tutCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("CNV"))
//            {
//                cnvCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("OPL"))
//            {
//                oplCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("INS"))
//            {
//                insCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("SEC"))
//            {
//                secCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("PRA"))
//            {
//                praCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("RQL"))
//            {
//                rqlCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("SEM"))
//            {
//                secCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("STL"))
//            {
//                stlCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//            }
//            else if(courseOffer.get(i).getComponentCode().equals("SEM"))
//                semCapacity+=courseOffer.get(i).getEnrolmentCapacity();
//
//        }
//    }

}
