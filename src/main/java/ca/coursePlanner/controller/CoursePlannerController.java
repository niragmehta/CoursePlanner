package ca.coursePlanner.controller;


import ca.coursePlanner.model.DepartmentToDeleteLater;
import ca.coursePlanner.model.Facade;
import ca.coursePlanner.model.TxtWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CoursePlannerController {

    @GetMapping("/api/dump-model")
    public String summarizeData() throws FileNotFoundException {
        Facade.writeDump();
        TxtWriter txtWriterInstance = TxtWriter.getInstance();
        return txtWriterInstance.getString();
    }

    @GetMapping("/api/about")
    public Object getAboutMessage() {
        return new Object() {
            public String appName = "Course Planner";
            public String authorName = "Nirag and Warren";
        };
    }

    @GetMapping("/api/departments")
    public List<DepartmentToDeleteLater> getDepartments() throws FileNotFoundException {
//        Facade.populateDepartmentList();
//        List<DepartmentToDeleteLater> departmentToDeleteLaters = DepartmentCollection.getInstance().getDepartmentToDeleteLaterList();

        List<DepartmentToDeleteLater> departmentToDeleteLaters = new ArrayList<>();
        DepartmentToDeleteLater dept1 = new DepartmentToDeleteLater(1, "CMPT");
        DepartmentToDeleteLater dept2 = new DepartmentToDeleteLater(2, "BUS");

        departmentToDeleteLaters.add(dept1);
        departmentToDeleteLaters.add(dept2);
        return departmentToDeleteLaters;
    }
}
