package ca.coursePlanner.controller;


import ca.coursePlanner.model.*;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
            public String appName = "Course Planner";
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
    public List<Offering> getOfferings(@PathVariable("deptId") int deptId, @PathVariable("courseId") int courseId){

        CourseCollection.populateCourseCollection(deptId);

        OfferingCollection.populateList(deptId,courseId);

//        Offering offering1=new Offering(1,"Burnaby","brian",2018,1977,"Fall");
//        Offering offering2=new Offering(2,"Surrey","Angela",8990,3220,"Summer");
//        List<Offering> offeringList=new ArrayList<>();
//        offeringList.add(offering1);
//        offeringList.add(offering2);
//        return offeringList;

        return OfferingCollection.getOfferingList();

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

    @PostMapping("/api/addoffering")
    public String addOffering(@RequestBody csvCourseUnit line) throws IOException {

        FileWriter fw=new FileWriter("data/course_data_2018.csv",true);

        fw.append("\n"+Integer.toString(line.getSemester())+","+line.getSubjectName()+","+line.getCatalogNumber()+","+
                line.getLocation()+","+","+ Integer.toString(line.getEnrollmentCap())+","+
                Integer.toString(line.getEnrollmentTotal())+","+line.getInstructor()+","+line.getComponent());

        fw.close();

        Facade.writeDump();
        DepartmentCollection.populateDepartmentList();

        String info="{\n";


        return info;

    }



}
