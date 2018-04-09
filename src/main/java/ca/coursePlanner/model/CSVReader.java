package ca.coursePlanner.model;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class CSVReader {

    public void read(String path) throws FileNotFoundException {
        // TODO: fix the ghost ', ,' prof  || ',' when two empty profs name
        String line = "";
        String cvsSplitBy = ",";

        TopicCollection topicCollectionInstance = TopicCollection.getInstance();
        List<csvCourseUnit> csvCourseUnitList = TopicCollection.getInstance().getCsvCsvCourseUnitList();

        //read the csv file
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

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
                csvCourseUnit csvCourseUnitTemp = new csvCourseUnit(Integer.parseInt(course[0]),
                        course[1],
                        course[2],
                        course[3],
                        Integer.parseInt(course[4]),
                        Integer.parseInt(course[5]),
                        instruc.toString(),
                        course[size]);

                csvCourseUnitList.add(csvCourseUnitTemp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(csvCourseUnitList, new TopicCollection());
        topicCollectionInstance.setCsvCsvCourseUnitList(csvCourseUnitList);
    }

    public static void sortList(List<csvCourseUnit> csvCourseUnitList, TopicCollection topicCollectionInstance) throws FileNotFoundException {
        Collections.sort(csvCourseUnitList, new TopicCollection());
        topicCollectionInstance.setCsvCsvCourseUnitList(csvCourseUnitList);

        PrintWriter pw = new PrintWriter(new File("test.csv"));
        for (int i = 0; i < csvCourseUnitList.size(); i++) {
            pw.append(csvCourseUnitList.get(i).toString());
            pw.append("\n");
        }

    }


}




