package ca.coursePlanner.model;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CSVReader {

    public void read() throws FileNotFoundException {

        String csvFile ="/Users/niragmehta/IdeaProjects/coursePlanner/data/course_data_2016.csv";
        String line = "";
        String cvsSplitBy = ",";

        CourseCollection courseCollectionInstance=CourseCollection.getInstance();
        List<Course> courseList=CourseCollection.getInstance().getCsvCourseList();

        //read the csv file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            line=br.readLine();
            while ((line = br.readLine()) != null) {


                // use comma as separator
                String[] course = line.split(cvsSplitBy);
                String instructors=course[6]+", ";
                instructors=instructors.substring(0,instructors.length()-2);
                int size=course.length-1;
                Course courseTemp=new Course(Integer.parseInt(course[0]),
                        course[1],
                        course[2],
                        course[3],
                        Integer.parseInt(course[4]),
                        Integer.parseInt(course[5]),
                        course[6],
                        course[size]);

                courseList.add(courseTemp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        sortList(courseList,courseCollectionInstance);
//        courseCollectionInstance.printDebug();

        Collections.sort(courseList,new CourseCollection());
        courseCollectionInstance.setCsvCourseList(courseList);


    }

    public static void sortList(List<Course> courseList,CourseCollection courseCollectionInstance) throws FileNotFoundException
    {
        Collections.sort(courseList,new CourseCollection());
        courseCollectionInstance.setCsvCourseList(courseList);

        PrintWriter pw = new PrintWriter(new File("test.csv"));
        for(int i=0;i<courseList.size();i++)
        {
            pw.append(courseList.get(i).toString());
            pw.append("\n");
        }

    }




}




