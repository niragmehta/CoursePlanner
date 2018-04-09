package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class Offering {

    private List<csvCourseUnit> csvCourseUnitList = new ArrayList<>();
    String subject;
    String catalogNumber;
    private String location;
    private int semester;

    List<String> componentType=new ArrayList<>();
    List<Integer> componentCapacity=new ArrayList<>();
    List<Integer> componentTotal=new ArrayList<>();
    List<String> instructors=new ArrayList<>();

    TxtWriter txtWriterInstance=TxtWriter.getInstance();

    public Offering(String location, int semester, String subject, String catalogNumber) {
        this.location = location;
        this.semester = semester;
        this.subject=subject;
        this.catalogNumber=catalogNumber;
    }

    public boolean addCourse(csvCourseUnit csvCourseUnit){
        if(csvCourseUnit.getLocation().equals(this.location) && csvCourseUnit.getSemester() == this.semester
                && csvCourseUnit.getSubject().equals(this.subject) && csvCourseUnit.getCatalogNumber().equals(this.catalogNumber))
        {
            csvCourseUnitList.add(csvCourseUnit);
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
        for(int i = 0; i< csvCourseUnitList.size(); i++)
        {
            if(!instructors.contains(csvCourseUnitList.get(i).getInstructor()))
                instructors.add(csvCourseUnitList.get(i).getInstructor());


            if(componentType.contains(csvCourseUnitList.get(i).getComponentCode()))
            {
                int index=componentType.indexOf(csvCourseUnitList.get(i).getComponentCode());

                int temp=componentCapacity.get(index)+ csvCourseUnitList.get(i).getEnrolmentCapacity();
                componentCapacity.set(index,temp);
                temp=componentTotal.get(index)+ csvCourseUnitList.get(i).getEnrolmentTotal();
                componentTotal.set(index,temp);
            }
            else
            {
                componentType.add(csvCourseUnitList.get(i).getComponentCode());
                componentCapacity.add(csvCourseUnitList.get(i).getEnrolmentCapacity());
                componentTotal.add(csvCourseUnitList.get(i).getEnrolmentTotal());
            }
        }
    }


    public List<csvCourseUnit> getCsvCourseUnitList() {
        return csvCourseUnitList;
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
