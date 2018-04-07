package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private int courseId;
    private String subject = "";
    private String catalogNumber = "";
    private List<Offering> coursesOfferList = new ArrayList<>();
    private TxtWriter txtWriterInstance = TxtWriter.getInstance();

    public Topic() {
    }

    public Topic(String subject, String catalogNumber) {
        this.subject = subject;
        this.catalogNumber = catalogNumber;
    }

    public void displayCourseTopic() {
        System.out.print(subject + " " + catalogNumber + "\n");
        txtWriterInstance.append(subject + " " + catalogNumber + "\n");

        for (int i = 0; i < coursesOfferList.size(); i++)
            coursesOfferList.get(i).displayCourseOffer();
    }

    public boolean addToOffer(Course course) {
        for (Offering offer : coursesOfferList) {
            if (offer.addCourse(course))
                return true;
        }

        if (course.getSubject().equals(subject) && course.getCatalogNumber().equals(catalogNumber)) {
            Offering offering = new Offering(course.getLocation(), course.getSemester(), course.getSubject(), course.getCatalogNumber());

            offering.addCourse(course);
            //offering.getCourseList().add(course);
            coursesOfferList.add(offering);
            return true;
        }
        return false;

        // check what is the course's location and semester
        // if a offer of that location and semester is found, add
        // else create new course offer
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

    public List<Offering> getCoursesOfferList() {
        return coursesOfferList;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "subject='" + subject + '\'' +
                ", catalogNumber='" + catalogNumber + '\'' +
                // ", coursesOfferList=" + coursesOfferList +
                '}';
    }
}
