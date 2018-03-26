package ca.coursePlanner.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class csvReader {

    public static void read() {

        String csvFile = "/Users/niragmehta/IdeaProjects/coursePlanner/data/course_data_2018.csv";
        String line = "";
        String cvsSplitBy = ",";
        HashMap<String,List<Course>> courseMap=CourseCollection.getCourseMap();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] course = line.split(cvsSplitBy);
                Course courseTemp=new Course();
                courseTemp.setSemester(Integer.parseInt(course[0]));
                courseTemp.setSubject(course[1]);
                courseTemp.setCatalogNumber(course[2]);
                courseTemp.setLocation(course[3]);
                courseTemp.setEnrolmentCapacity(Integer.parseInt(course[4]));
                courseTemp.setEnrolmentTotal(Integer.parseInt(course[5]));
                courseTemp.setInstructor(course[6]);
                courseTemp.setComponentCode(course[7]);



                System.out.println( course[1]+"\t"+course[3]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}




