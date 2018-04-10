package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CourseCollection {

    private static List<Course> courseList=new ArrayList<>();


    public static void populateCourseCollection(int id)
    {
        courseList = new ArrayList<>();

        String name="";
        List<Department> departmentList=DepartmentCollection.getDepartmentList();
        
        for(int i=0;i<departmentList.size();i++)
        {
            if(id==departmentList.get(i).getDeptId())
            {
                name=departmentList.get(i).getName();
                break;
            }
        }

        AtomicInteger atomicInteger=new AtomicInteger();

        Course courseTemp=new Course();
        List<Topic> topicList=TopicCollection.getInstance().getTopicList();

        for(int i=0;i<topicList.size();i++)
        {
            if(name.equals(topicList.get(i).getSubject()))
            {
                courseTemp.setCourseId(atomicInteger.incrementAndGet());
                courseTemp.setCatalogNumber(topicList.get(i).getCatalogNumber());
                courseList.add(courseTemp);
                courseTemp=new Course();
            }
        }


    }

    public static Course getCourseById(int courseId)
    {
        Course course=new Course();
        for(int i=0;i<courseList.size();i++)
        {
            if(courseId==courseList.get(i).getCourseId())
            {
                course=courseList.get(i);
                break;
            }
        }
        return course;
    }

    public static List<Course> getCourseList() {
        return courseList;
    }
}
