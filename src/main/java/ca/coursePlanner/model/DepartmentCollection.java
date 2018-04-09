package ca.coursePlanner.model;

import javafx.animation.TranslateTransitionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DepartmentCollection {

    private static List<Department> departmentList=new ArrayList<>();

    public static void populateDepartmentList()
    {
        departmentList = new ArrayList<>();
        TopicCollection.getInstance().populateTopicList();
        List<Topic> topicList=TopicCollection.getInstance().getTopicList();

        AtomicInteger atomicInteger=new AtomicInteger();

        Department departmentTemp=new Department(topicList.get(0).getSubject(),atomicInteger.incrementAndGet());
        for(int i=0;i<topicList.size();i++) {

            if (i == topicList.size() - 1)
            {
                departmentList.add(departmentTemp);
                return;
            }

            if(departmentTemp.getName().equals(topicList.get(i).getSubject()))
            {
                continue;
            }
            else
            {
                departmentList.add(departmentTemp);
                departmentTemp=new Department();
                departmentTemp.setName(topicList.get(i).getSubject());
                departmentTemp.setDeptId(atomicInteger.incrementAndGet());
            }
        }

    }

    public static List<Department> getDepartmentList() {
        return departmentList;
    }
}
