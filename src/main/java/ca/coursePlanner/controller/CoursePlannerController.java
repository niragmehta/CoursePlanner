package ca.coursePlanner.controller;


import ca.coursePlanner.model.*;
import ca.coursePlanner.model.Watcher.Watcher;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class CoursePlannerController {
    private AtomicInteger nextId = new AtomicInteger();
    private List<Watcher> watchers = new ArrayList<>();

    @GetMapping("/api/dump-model")
    public String summarizeData() throws FileNotFoundException {
        Facade.writeDump();

        String info = "DEPT=" + DepartmentCollection.getDepartmentList().size() + "\n"
                + "COURSE=" + TopicCollection.getInstance().getTopicList().size() + "\n"
                + "OFFERING=" + Facade.getTotalCourseOfferingCount();

        return info;
//        TxtWriter txtWriterInstance = TxtWriter.getInstance();
    }

    @GetMapping("/api/about")
    public Object getAboutMessage() {
        return new Object() {
            public String appName = "Course Planner";
            public String authorName = "Nirag and Warren";
        };
    }

    @GetMapping("/api/departments")
    public List<Department> getDepartments() throws FileNotFoundException {
        return DepartmentCollection.getDepartmentList();
    }

    @GetMapping("api/departments/{id}/courses")
    public List<Course> getSpecificCourse(@PathVariable("id") int deptId) {
        CourseCollection.populateCourseCollection(deptId);
        return CourseCollection.getCourseList();
    }

    @GetMapping("/api/departments/{deptId}/courses/{courseId}/offerings")
    public List<Offering> getOfferings(@PathVariable("deptId") int deptId, @PathVariable("courseId") int courseId) {

        CourseCollection.populateCourseCollection(deptId);

        OfferingCollection.populateList(deptId, courseId);

        return OfferingCollection.getOfferingList();
    }

    @GetMapping("/api/watchers")
    public List<Watcher> getWatchers() {
        List<Watcher> watchers = new ArrayList<>();
        for (Course course : CourseCollection.getCourseList()) {
            for (Watcher watcher : course.getObserverList()) {
                watchers.add(watcher);
            }
        }
        return watchers;
    }

    @GetMapping("/api/departments/{deptId}/courses/{courseId}/offerings/{courseOfferingId}")
    public List<Section> getSection(@PathVariable("deptId") int deptId,
                              @PathVariable("courseId") int courseId,
                              @PathVariable("courseOfferingId") int courseOfferingId)
    {
        CourseCollection.populateCourseCollection(deptId);
        OfferingCollection.populateList(deptId,courseId);

        SectionCollection.populateSectionCollection(courseOfferingId);

        return SectionCollection.getSectionList();
    }

    @PostMapping("/api/watchers")
    public Watcher addOneWatcher(@RequestBody IdHolder idHolder) {
        int courseId = idHolder.getCourseId();
        int deptId = idHolder.getDeptId();

        CourseCollection.populateCourseCollection(deptId);
        OfferingCollection.populateList(deptId, courseId);

        Department targetDepartment = DepartmentCollection.getDepartmentById(deptId);
        Course targetCourse = CourseCollection.getCourseById(courseId);

        Watcher watcher = new Watcher(targetDepartment,targetCourse);

        return watcher;
    }


    @PostMapping("/api/addoffering")
    public Section addOffering(@RequestBody csvCourseUnit line) throws IOException {

        FileWriter fw = new FileWriter("data/course_data_2018.csv", true);

        fw.append("\n" + Integer.toString(line.getSemester())
                + "," + line.getSubjectName()
                + "," + line.getCatalogNumber()
                + "," + line.getLocation()
                + "," + Integer.toString(line.getEnrollmentCap())
                + "," + Integer.toString(line.getEnrollmentTotal())
                + "," + line.getInstructor()
                + "," + line.getComponent());
        fw.close();

        Facade.writeDump();
        DepartmentCollection.populateDepartmentList();

        Section section=new Section(line.getComponent(),line.getEnrollmentTotal(),line.getEnrollmentCap());

        return section;
    }
}
