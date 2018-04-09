package ca.coursePlanner.model;

public class Course {

    private int courseId;
    private String catalogNumber;

    public Course(){}

    public Course(int id, String catalogNumber) {
        this.courseId = id;
        this.catalogNumber = catalogNumber;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }
}
