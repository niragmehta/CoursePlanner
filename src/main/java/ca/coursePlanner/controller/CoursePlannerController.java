package ca.coursePlanner.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursePlannerController {



    @PostMapping("/dump-model")
    public void summarizeData()
    {

    }

}
