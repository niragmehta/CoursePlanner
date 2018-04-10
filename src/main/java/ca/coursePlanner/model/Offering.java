package ca.coursePlanner.model;

import ca.coursePlanner.model.Watcher.Watcher;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Offering{

    private int courseOfferingId;
    private String location;
    private String instructors;
    private int year;
    private int semesterCode;
    private String term;


    List<Section> sectionList=new ArrayList<>();

    List<String> componentType=new ArrayList<>();
    List<Integer> componentCapacity=new ArrayList<>();
    List<Integer> componentTotal=new ArrayList<>();

    private Course course;

    Offering(){}

    public Offering(int courseOfferingId, String location, String instructors, int year, int semesterCode, String term) {
        this.courseOfferingId = courseOfferingId;
        this.location = location;
        this.instructors = instructors;
        this.year = year;
        this.semesterCode = semesterCode;
        this.term = term;
    }

    public int getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(int courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemesterCode() {
        return semesterCode;
    }

    public void setSemesterCode(int semesterCode) {
        this.semesterCode = semesterCode;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<String> getComponentType() {
        return componentType;
    }

    public void setComponentType(List<String> componentType) {
        this.componentType = componentType;
    }

    public List<Integer> getComponentCapacity() {
        return componentCapacity;
    }

    public void setComponentCapacity(List<Integer> componentCapacity) {
        this.componentCapacity = componentCapacity;
    }

    public List<Integer> getComponentTotal() {
        return componentTotal;
    }

    public void setComponentTotal(List<Integer> componentTotal) {
        this.componentTotal = componentTotal;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
