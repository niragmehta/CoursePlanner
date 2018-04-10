package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class StatDataCollection {


    private static List<StatData> statDataList=new ArrayList<>();

    public static void populateStatDataList(int deptId)
    {
        Department department=DepartmentCollection.getDepartmentById(deptId);

        List<Topic> topicList=TopicCollection.getInstance().getTopicList();

        StatData statData=new StatData();
        int enrollment=0;


        List<csvCourseUnit> list=TopicCollection.getInstance().getCsvCsvCourseUnitList();

        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getSubjectName().equals(department.getName()) && list.get(i).getComponent().equals("LEC"))
            {

                if(map.get(list.get(i).getSemester())==null)
                    map.put(list.get(i).getSemester(),0);

                int value=map.get(list.get(i).getSemester());
                value+=list.get(i).getEnrollmentTotal();
                map.put(list.get(i).getSemester(),value);
            }
        }

        for(int key : map.keySet())
        {
            statData.setTotalCoursesTaken(map.get(key));
            statData.setSemesterCode(key);
            statDataList.add(statData);
            statData=new StatData();
        }



    }

    public static List<StatData> getStatDataList() {
        return statDataList;
    }
}
