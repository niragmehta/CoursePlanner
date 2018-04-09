package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String subject = "";
    private String catalogNumber = "";
    private List<CourseByCampus> coursesOfferList = new ArrayList<>();
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

    public boolean addToOffer(csvCourseUnit csvCourseUnit) {
        for (CourseByCampus offer : coursesOfferList) {
            if (offer.addCourse(csvCourseUnit))
                return true;
        }

        if (csvCourseUnit.getSubjectName().equals(subject) && csvCourseUnit.getCatalogNumber().equals(catalogNumber)) {
            CourseByCampus courseByCampus = new CourseByCampus(csvCourseUnit.getLocation(), csvCourseUnit.getSemester(), csvCourseUnit.getSubjectName(), csvCourseUnit.getCatalogNumber());

            courseByCampus.addCourse(csvCourseUnit);
            //courseByCampus.getCsvCourseUnitList().add(csvCourseUnit);
            coursesOfferList.add(courseByCampus);
            return true;
        }
        return false;

        // check what is the csvCourseUnit's location and semester
        // if a offer of that location and semester is found, add
        // else create new csvCourseUnit offer
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

    public List<CourseByCampus> getCoursesOfferList() {
        return coursesOfferList;
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
