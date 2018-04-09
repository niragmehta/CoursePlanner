package ca.coursePlanner.model;

public class Course {

    private int id;
    private String catalogNumber;

    public Course(){}

    public Course(int id, String catalogNumber) {
        this.id = id;
        this.catalogNumber = catalogNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }
}
