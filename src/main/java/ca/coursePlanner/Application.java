package ca.coursePlanner;

import ca.coursePlanner.model.DepartmentCollection;
import ca.coursePlanner.model.Facade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class Application {
    public static void main(String args[]) throws FileNotFoundException {
        Facade.writeDump();
        DepartmentCollection.populateDepartmentList();

        SpringApplication.run(Application.class,args);
    }
}
