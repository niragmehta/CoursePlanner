package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class CourseOffer {

    private List<Course> courseOffer=new ArrayList<>();
    private String subject="";
    private String catalogNumber="";
    private int enrollmentCapacity;
    private int semester;
    private String location;

    private int tutCapacity;
    private int labCapacity;
    private int lectureCapacity;
    private int cnvCapacity;
    private int oplCapacity;
    private int insCapacity;
    private int secCapacity;
    private int stlCapacity;
    private int praCapacity;
    private int rqlCapacity;
    private int semCapacity;

    public CourseOffer(List<Course> courseOffer, String subject, String catalogNumber,int enrollmentCapacity,int semester,String location) {
        this.courseOffer = courseOffer;
        this.subject = subject;
        this.catalogNumber = catalogNumber;
        this.enrollmentCapacity=enrollmentCapacity;
        this.semester=semester;
        this.location=location;
        calculateCapacity();
    }

    public void calculateCapacity()
    {
        for(int i=0;i<courseOffer.size();i++)
        {
            if(courseOffer.get(i).getComponentCode().equals("LEC"))
            {
                lectureCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("LAB"))
            {
                labCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("TUT"))
            {
                tutCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("CNV"))
            {
                cnvCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("OPL"))
            {
                oplCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("INS"))
            {
                insCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("SEC"))
            {
                secCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("PRA"))
            {
                praCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("RQL"))
            {
                rqlCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("SEM"))
            {
                secCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("STL"))
            {
                stlCapacity+=courseOffer.get(i).getEnrolmentCapacity();
            }
            else if(courseOffer.get(i).getComponentCode().equals("SEM"))
                semCapacity+=courseOffer.get(i).getEnrolmentCapacity();

        }
    }


    public String getSubject() {
        return subject;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public int getLabCapacity() {
        return labCapacity;
    }

    public int getLectureCapacity() {
        return lectureCapacity;
    }

    public void setCourseOffer(List<Course> courseOffer) {
        this.courseOffer = courseOffer;
    }

    public int getTutCapacity() {
        return tutCapacity;
    }

    public int getCnvCapacity() {
        return cnvCapacity;
    }

    public int getOplCapacity() {
        return oplCapacity;
    }

    public int getInsCapacity() {
        return insCapacity;
    }

    public int getSecCapacity() {
        return secCapacity;
    }

    public List<Course> getCourseOffer() {
        return courseOffer;
    }

    public int getStlCapacity() {
        return stlCapacity;
    }

    public int getPraCapacity() {
        return praCapacity;
    }

    public int getRqlCapacity() {
        return rqlCapacity;
    }

    public int getSemCapacity() {
        return semCapacity;
    }

}
