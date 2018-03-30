package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class CourseTopic {

    String subject="";
    String catalogNumber="";
    List<CourseOffer> coursesOfferList =new ArrayList<>();


    public CourseTopic(){}

    public CourseTopic(String subject, String catalogNumber) {
        this.subject = subject;
        this.catalogNumber = catalogNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public List<CourseOffer> getCoursesOfferList() {
        return coursesOfferList;
    }


    public boolean addToOffer(Course course)
    {
        for(CourseOffer offer : coursesOfferList){
            if(offer.addCourse(course))
                return true;
        }

        if(course.getSubject().equals(subject) && course.getCatalogNumber().equals(catalogNumber))
        {
            CourseOffer courseOffer = new CourseOffer(course.getLocation(), course.getSemester(),course.getSubject(),course.getCatalogNumber());

            courseOffer.addCourse(course);
            //courseOffer.getCourseList().add(course);
            coursesOfferList.add(courseOffer);
            return true;
        }
        return false;

        // check what is the course's location and semester
        // if a offer of that location and semester is found, add
        // else create new course offer

    }

    @Override
    public String toString() {
        return "CourseTopic{" +
                "subject='" + subject + '\'' +
                ", catalogNumber='" + catalogNumber + '\'' +
               // ", coursesOfferList=" + coursesOfferList +
                '}';
    }
}
