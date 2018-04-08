package ca.coursePlanner.model;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class CSVReader {

public static void read() throws FileNotFoundException {
        // TODO: fix the ghost ', ,' prof  || ',' when two empty profs name
        String line = "";
        String cvsSplitBy = ",";

        TopicCollection topicCollectionInstance = TopicCollection.getInstance();
        List<Course> courseList = TopicCollection.getInstance().getCsvCourseList();

        //read the csv file
        try (BufferedReader br = new BufferedReader(new FileReader("data/course_data_2018.csv"))) {
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] course = line.split(cvsSplitBy);

                StringBuilder instruc = new StringBuilder();
                if (course.length > 8) {
                    for (int i = 6; i < course.length - 1; i++) {
                        instruc.append(course[i] + ", ");
                    }
                    instruc.replace(instruc.length() - 2, instruc.length() - 1, "");
                } else {
                    instruc = new StringBuilder(course[6]);
                }
                if (instruc.toString().equals("(null)") || instruc.toString().equals("<null>")) {
                    instruc = new StringBuilder("");
                }

                int size = course.length - 1;
                Course courseTemp = new Course(Integer.parseInt(course[0]),
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

        Collections.sort(courseList, new TopicCollection());
        topicCollectionInstance.setCsvCourseList(courseList);
    }

    public static void sortList(List<Course> courseList, TopicCollection topicCollectionInstance) throws FileNotFoundException {
        Collections.sort(courseList, new TopicCollection());
        topicCollectionInstance.setCsvCourseList(courseList);

        PrintWriter pw = new PrintWriter(new File("test.csv"));
        for (Course aCourseList : courseList) {
            pw.append(aCourseList.toString());
            pw.append("\n");
        }
    }
}




