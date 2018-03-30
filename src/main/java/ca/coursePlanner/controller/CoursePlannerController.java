package ca.coursePlanner.controller;


import ca.coursePlanner.model.CourseTopic;
import ca.coursePlanner.model.Facade;
import ca.coursePlanner.model.TxtWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class CoursePlannerController {


    @GetMapping("/dump-model")
    public String summarizeData() throws FileNotFoundException {
        Facade.writeDump();
        TxtWriter txtWriterInstance=TxtWriter.getInstance();
        return txtWriterInstance.getString();
    }

}
