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
        List<Course> courseList=CourseCollection.getInstance();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            line=br.readLine();
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

                courseList.add(courseTemp);


                //System.out.println( course[1]+"\t"+course[3]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writeToCSV(courseList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        Collections.sort(courseList,new CourseCollection());
//        for(int i=0;i<courseList.size();i++)
//        {
//            System.out.println(courseList.get(i).toString());
//        }

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




