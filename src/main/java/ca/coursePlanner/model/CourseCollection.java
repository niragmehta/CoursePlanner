package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseCollection implements Comparator<Course>{

    private static List<Course> courseList;

    public static List<Course> getInstance() {
        if(courseList == null){
            courseList = new ArrayList<>();
        }
        return courseList;
    }



    public void extractCourses()
    {

    }


    @Override
    public int compare(Course o1, Course o2) {

        int value1=o1.getCatalogNumber().compareTo(o2.getCatalogNumber());
        if(value1==0)
        {
            String o1Semester=Integer.toString(o1.getSemester());
            String o2Semster=Integer.toString(o2.getSemester());
            int value2=o1Semester.compareTo(o2Semster);
            if(value2==0)
            {
                int value3=o1.getLocation().compareTo(o2.getLocation());
                if(value3==0)
                {
                    int value4=o1.getSubject().compareTo(o2.getSubject());
                    if(value4==0)
                    {
                        int value5=o1.getInstructor().compareTo(o2.getInstructor());
                        if(value5==0)
                        {
                            int value6=o2.getComponentCode().compareTo(o1.getComponentCode());
                            return value6;
                        }
                        return value5;
                    }
                    else return value4;

                }
                return value3;
            }
            else
                return value2;

        }
        else
            return value1;
    }
}
