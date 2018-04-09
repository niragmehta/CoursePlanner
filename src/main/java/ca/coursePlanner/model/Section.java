package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private String type;
    private int enrollmentTotal;
    private int enrollmentCap;



//    public static void populateSection(int courseOfferingId)
//    {
//
//        section=new Section();
//
//        Offering offering=OfferingCollection.getOfferingById(courseOfferingId);
//
//        int temp=0;
//        for(int i=0;i<offering.getComponentTotal().size();i++)
//        {
//            temp+=offering.getComponentTotal().get(i);
//        }
//        section.setEnrollmentTotal(temp);
//        temp=0;
//
//        for(int i=0;i<offering.getComponentCapacity().size();i++)
//            temp+=offering.getComponentCapacity().get(i);
//        section.setEnrollmentCap(temp);
//
//        StringBuilder stringBuilder=new StringBuilder();
//        for(int i=0;i<offering.getComponentType().size();i++)
//        {
//            stringBuilder.append(offering.getComponentType().get(i)+",");
//        }
//
//        section.setType(stringBuilder.toString());
//
//
//    }

    Section(){}

    public Section(String type, int enrollmentTotal, int enrollmentCap) {
        this.type = type;
        this.enrollmentTotal = enrollmentTotal;
        this.enrollmentCap = enrollmentCap;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEnrollmentTotal() {
        return enrollmentTotal;
    }

    public void setEnrollmentTotal(int enrollmentTotal) {
        this.enrollmentTotal = enrollmentTotal;
    }

    public int getEnrollmentCap() {
        return enrollmentCap;
    }

    public void setEnrollmentCap(int enrollmentCap) {
        this.enrollmentCap = enrollmentCap;
    }

}
