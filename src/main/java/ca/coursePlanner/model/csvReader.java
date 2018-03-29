package ca.coursePlanner.model;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class csvReader{

    public static void main(String[] args)
    {

        String csvFile ="/Users/niragmehta/IdeaProjects/coursePlanner/data/course_data_2016.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<Course> courseList=CourseCollection.getInstance().getCsvCourseList();

        //read the csv file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            line=br.readLine();
            while ((line = br.readLine()) != null) {


                // use comma as separator
                String[] course = line.split(cvsSplitBy);
                String instructors=course[6]+", ";

                if(course.length>8)
                {
                    for(int i=7;i<course.length-2;i++)
                        instructors+=course[i]+", ";
                }
                instructors=instructors.substring(0,instructors.length()-2);
                Course courseTemp=new Course(Integer.parseInt(course[0]),
                        course[1],
                        course[2],
                        course[3],
                        Integer.parseInt(course[4]),
                        Integer.parseInt(course[5]),
                        instructors,
                        course[7]);

                courseList.add(courseTemp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writeToCSV(courseList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void writeToCSV(List<Course> courseList) throws FileNotFoundException
    {
        Collections.sort(courseList,new CourseCollection());
        PrintWriter pw = new PrintWriter(new File("test.csv"));
        for(int i=0;i<courseList.size();i++)
        {
            pw.append(courseList.get(i).toString());
            pw.append("\n");
        }

    }


}




