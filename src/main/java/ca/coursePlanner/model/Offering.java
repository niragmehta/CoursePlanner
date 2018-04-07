package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class models a course offered at a given semester and given campus location
 */
public class Offering {

    private List<Course> courseList = new ArrayList<>();
    private String subject;
    private String catalogNumber;
    private String location;
    private int semester;
    private int courseOfferingId;
    private List<String> componentType=new ArrayList<>();
    private List<Integer> componentCapacity=new ArrayList<>();
    private List<Integer> componentTotal=new ArrayList<>();
    private List<String> instructors=new ArrayList<>();

    TxtWriter txtWriterInstance=TxtWriter.getInstance();

    public Offering(String location, int semester, String subject, String catalogNumber) {
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
        System.out.print("\t"+semester+" in "+location + " by ");
        txtWriterInstance.append("\t"+semester+" in "+location + " by ");


        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < instructors.size(); i++)
        {
            stringBuilder.append(instructors.get(i)+", ");
        }

        stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length()-1,"");
        System.out.print(stringBuilder.toString());
        txtWriterInstance.append(stringBuilder.toString());

        System.out.println();
        txtWriterInstance.append("\n");
        for(int i=0;i<componentType.size();i++)
        {
            System.out.println("\t\tTYPE="+componentType.get(i)+", Enrollment= "+componentTotal.get(i)+"/"+componentCapacity.get(i));
            txtWriterInstance.append("\t\tTYPE="+componentType.get(i)+", Enrollment= "+componentTotal.get(i)+"/"+componentCapacity.get(i)+"\n");
        }

        System.out.println();
        //txtWriterInstance.append("\n");
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
                temp=componentTotal.get(index)+courseList.get(i).getEnrolmentTotal();
                componentTotal.set(index,temp);
            }
            else
            {
                componentType.add(courseList.get(i).getComponentCode());
                componentCapacity.add(courseList.get(i).getEnrolmentCapacity());
                componentTotal.add(courseList.get(i).getEnrolmentTotal());
            }
        }
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

}
