package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseCollection implements Comparator<Course> {

    private List<Course> csvCourseList = new ArrayList<>();
    private List<CourseOffer> allCourseOfferings = new ArrayList<>();

    private static CourseCollection instance = null;

    public static CourseCollection getInstance() {
        if (instance == null)
            instance = new CourseCollection();
        return instance;

    }

    

    //populates the list of CourseOffers
//    public void extractCourses() {
//        Collections.sort(csvCourseList, new CourseCollection());
//        List<Course> temp=new ArrayList<>();
//        String subject="";
//        String catalogNumber="";
//        String location="";
//        int semester=0;
//        int enrollmentCapacity=0;
//        int check = 0;
//
//        for (int i = 0; i < csvCourseList.size(); i++) {
//
//            if(check==0)
//            {
//                temp=new ArrayList<>();
//                temp.add(csvCourseList.get(i));
//                subject=csvCourseList.get(i).getSubject();
//                catalogNumber=csvCourseList.get(i).getCatalogNumber();
//                location=csvCourseList.get(i).getLocation();
//                semester=csvCourseList.get(i).getSemester();
//                enrollmentCapacity=csvCourseList.get(i).getEnrolmentCapacity();
//                ++check;
//                continue;
//            }
//            if(csvCourseList.get(i).getSubject().equals(subject)
//                    && csvCourseList.get(i).getCatalogNumber().equals(catalogNumber)
//                    && csvCourseList.get(i).getLocation().equals(location)
//                    && Integer.toString(csvCourseList.get(i).getSemester()).equals(Integer.toString(semester)))
//            {
//                temp.add(csvCourseList.get(i));
//            }
//            else
//            {
//                CourseOffer courseOffer=new CourseOffer(temp,subject,catalogNumber,enrollmentCapacity,semester,location);
//                allCourseOfferings.add(courseOffer);
//                temp=new ArrayList<>();
//                temp.add(csvCourseList.get(i));
//                check=0;
//                continue;
//            }
//
//        }
//    }


    @Override
    public int compare(Course o1, Course o2) {

        int value1 = o1.getSubject().compareTo(o2.getSubject());
        if (value1 == 0) {
//            int value2=o1Semester.compareTo(o2Semster);
            int value2 = o1.getCatalogNumber().compareTo(o2.getCatalogNumber());
            if (value2 == 0) {
                String o1Semester = Integer.toString(o1.getSemester());
                String o2Semster = Integer.toString(o2.getSemester());
                int value3 = o1Semester.compareTo(o2Semster);
                if (value3 == 0) {
                    int value4 = o1.getLocation().compareTo(o2.getLocation());
                    return value4;

                }
                return value3;
            } else
                return value2;

        } else
            return value1;
    }


    public List<Course> getCsvCourseList() {
        return csvCourseList;
    }

    public void setCsvCourseList(List<Course> csvCourseList) {
        instance.csvCourseList = csvCourseList;
    }

    public List<CourseOffer> getAllCourseOfferings() {
        return allCourseOfferings;
    }

    public void setAllCourseOfferings(List<CourseOffer> allCourseOfferings) {
        this.allCourseOfferings = allCourseOfferings;
    }
}
