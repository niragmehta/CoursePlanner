package ca.coursePlanner.model;

import ca.coursePlanner.model.Watcher.Watcher;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Course implements Subject{

    private int courseId;
    private String catalogNumber;
    @JsonIgnore
    private List<Offering> offeringList=new ArrayList<>();

    @JsonIgnore
    private List<Watcher> observerList = new ArrayList<>();

    @Override
    public void notifyWatchers() {
        for(Watcher watcher : observerList){
            watcher.update();
        }
    }

    @Override
    public void registerWatchers(Watcher watcher) {
        observerList.add(watcher);
    }
    public Course() {
    }

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

    public List<Offering> getOfferingList() {
        return offeringList;
    }

    public void setOfferingList(List<Offering> offeringList) {
        this.offeringList = offeringList;
    }

    public List<Watcher> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Watcher> observerList) {
        this.observerList = observerList;
    }
}
