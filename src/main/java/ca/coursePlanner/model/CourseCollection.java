package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CourseCollection {

    //private List<Course> courseList=new ArrayList<>();
    private static HashMap<String,List<Course>> courseMap = new HashMap<String,List<Course>>();

    CourseCollection(){}
    public CourseCollection(HashMap<String, List<Course>> courseMap) {
        this.courseMap = courseMap;
    }

    public static HashMap<String, List<Course>> getCourseMap() {
        return courseMap;
    }
}
