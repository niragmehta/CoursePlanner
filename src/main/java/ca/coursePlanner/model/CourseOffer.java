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
        System.out.print("\t"+semester+" in "+location + " by ");

        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < instructors.size(); i++)
        {
            stringBuilder.append(instructors.get(i)+", ");
        }
        stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length()-1,"");
        System.out.print(stringBuilder.toString());

        System.out.println();
        for(int i=0;i<componentType.size();i++)
        {
            System.out.println("\t\tTYPE="+componentType.get(i)+", Enrollment= "+componentTotal.get(i)+"/"+componentCapacity.get(i));
        }
        System.out.println();
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
