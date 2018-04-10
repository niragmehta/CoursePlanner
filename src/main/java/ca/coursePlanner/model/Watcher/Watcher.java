package ca.coursePlanner.model.Watcher;

import ca.coursePlanner.model.Course;
import ca.coursePlanner.model.Department;
import ca.coursePlanner.model.Section;

import java.util.ArrayList;
import java.util.List;
import ca.coursePlanner.model.Offering;

import java.util.Date;

public class Watcher implements CourseWatcher{
    int id;
    Department department;
    Course course;
    List<String> events = new ArrayList<>();
    List<Section> components = new ArrayList<>();

    public Watcher(Course course) {
        this.course = course;
    }

    public Watcher() {
    }

    public Watcher(Department department, Course course) {
        this.course = course;
        this.department = department;
        this.id = 0;
    }

    @Override
    public void update() {
        events.add(makeEvent(course));
    }

    private String makeEvent(Course course) {
        String event =  "";

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

    public List<Section> getComponents() {
        return components;
    }

    public void setComponents(List<Section> components) {
        this.components = components;
    }
}
