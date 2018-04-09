package ca.coursePlanner.controller;


import ca.coursePlanner.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class CoursePlannerController {

    @GetMapping("/api/dump-model")
    public String summarizeData() throws FileNotFoundException {
        Facade.writeDump();

        String info="DEPT="+DepartmentCollection.getDepartmentList().size()+"\n"
                +"COURSE="+ TopicCollection.getInstance().getTopicList().size()+"\n"
                +"OFFERING="+Facade.getTotalCourseOfferingCount();

        return info;
//        TxtWriter txtWriterInstance = TxtWriter.getInstance();
    }

    @GetMapping("/api/about")
    public Object getAboutMessage() {
        return new Object(){
            public String appName = "csvCourseUnit Planner";
            public String authorName = "Nirag and Warren";
        };
    }

    @GetMapping("/api/departments")
    public List<Department> getDepartments() throws FileNotFoundException
    {
        return DepartmentCollection.getDepartmentList();
    }

    @GetMapping("api/departments/{id}/courses")
    public List<Course> getSpecificCourse(@PathVariable("id") int deptId)
    {
        CourseCollection.populateCourseCollection(deptId);
        return CourseCollection.getCourseList();
    }

    @GetMapping("/api/departments/{deptId}/courses/{courseId}/offerings")
    public List<Offering> getOfferings(@PathVariable("deptIs") int deptId, @PathVariable("courseId") int courseId){

        CourseCollection.populateCourseCollection(deptId);

        OfferingCollection.populateList(deptId,courseId);

        return OfferingCollection.getOfferingList();

    }




}
