package ca.coursePlanner.model;


public class Section{

    private String type;
    private int enrollmentTotal;
    private int enrollmentCap;

    public Section(){}

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
