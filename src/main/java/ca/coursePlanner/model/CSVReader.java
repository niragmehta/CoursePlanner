package ca.coursePlanner.model;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CSVReader {

    public void read(String path) throws FileNotFoundException {

        String csvFile = path;
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

                StringBuilder instruc=new StringBuilder();
                if(course.length>8)
                {
                    for(int i=6;i<course.length-1;i++)
                    {

                        instruc.append(course[i]+", ");
                    }
                    instruc.replace(instruc.length()-2,instruc.length()-1,"");
                }
                else {

                    instruc=new StringBuilder(course[6]);
                }

                if(instruc.toString().equals("(null)"))
                {
                    instruc=new StringBuilder("");
                }

                int size=course.length-1;
                Course courseTemp=new Course(Integer.parseInt(course[0]),
                        course[1],
                        course[2],
                        course[3],
                        Integer.parseInt(course[4]),
                        Integer.parseInt(course[5]),
                        instruc.toString(),
                        course[size]);

                courseList.add(courseTemp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

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




