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
//
//        statDataList.add(new StatData(1,2));
//        statDataList.add(new StatData(3,7));

//        for(int i=0;i<topicList.size();i++)
//        {
//            //if same department, ie cmpt
//            if(topicList.get(i).getSubject().equals(department.getName()))
//            {
//                //iterate through CourseByCampus
//                for(int j=0;j<topicList.get(i).getCoursesOfferList().size();j++)
//                {
//                    int semester=topicList.get(i).getCoursesOfferList().get(j).getSemester();
//                    //iterate through list of components within courseByCampus
//                    topicList.get(i).getCoursesOfferList().get(j).PopulateEnrollmentTotal();
//                    for(int k=0;k<topicList.get(i).getCoursesOfferList().get(j).getComponentType().size();k++)
//                    {
//                        if(topicList.get(i).getCoursesOfferList().get(j).getComponentType().get(k).equals("LEC"))
//                        {
//                            enrollment+=topicList.get(i).getCoursesOfferList().get(j).getComponentTotal().get(k);
//
//                            statData.setSemesterCode(topicList.get(i).getCoursesOfferList().get(j).getSemester());
//                            statData.setTotalCoursesTaken(enrollment);
//
//                            break;
//                        }
//                    }
//                }
//            }
//            statDataList.add(statData);
//            statData=new StatData();
//            enrollment=0;
//
//        }

    }

    public static List<StatData> getStatDataList() {
        return statDataList;
    }
}
