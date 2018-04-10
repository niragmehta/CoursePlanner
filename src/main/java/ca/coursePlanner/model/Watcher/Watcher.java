package ca.coursePlanner.model.Watcher;

import ca.coursePlanner.model.Course;
import ca.coursePlanner.model.Department;
import ca.coursePlanner.model.Offering;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Watcher implements CourseWatcher{
    int id;
    Department department;
    Course course;
    List<String> events = new ArrayList<>();

    public Watcher() {
    }

    public Watcher(Department department, Course course) {
        this.course = course;
        this.department = department;
        this.id = 0;
    }

    @Override
    public void update() {
        for(Offering offering : course.getOfferingList()){
            events.add(makeEvent(offering));
        }
    }

    private String makeEvent(Offering offering ) {
        //Sun Mar 25 21:41:35 PDT 2018: Added section LEC with enrollment (89 / 90)
        //to offering Spring 2019
        String event = "";
        Date date = new Date();

//        String type = offering.getComponentType();

        //String event =  date.toString() + " Added section " + [type] with enrollment ([total]/[cap]) to offering [term] [year]" ;

        return event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }
}
