package ca.coursePlanner.controller;


import ca.coursePlanner.model.Facade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class CoursePlannerController {


    @GetMapping("/dump-model")
    public void summarizeData() throws FileNotFoundException {
        Facade.writeDump();
    }

}
