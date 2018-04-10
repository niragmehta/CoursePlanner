package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class StatDataCollection {


    private static List<StatData> statDataList=new ArrayList<>();

    public static void populateStatDataList(int deptId)
    {
        Department department=DepartmentCollection.getDepartmentById(deptId);

        List<Topic> topicList=TopicCollection.getInstance().getTopicList();
        for(int i=0;i<topicList.size();i++)
        {
            //if same department, ie cmpt
            if(topicList.get(i).getSubject().equals(department.getName()))
            {
                //iterate through CourseByCampus
                for(int j=0;j<topicList.get(i).getCoursesOfferList().size();j++)
                {
                    //interate through list of components within courseByCampus
                    for(int k=0;k<topicList.get(i).getCoursesOfferList().get(j).getComponentType().size();k++)
                    {
                        if(topicList.get(i).getCoursesOfferList().get(j).getComponentType().get(k).equals("LEC"))
                        {
                            StatData statData=new StatData();
                            statData.setSemesterCode(topicList.get(i).getCoursesOfferList().get(j).getSemester());
                            statData.setTotalCoursesTaken(topicList.get(i).getCoursesOfferList().get(j).getComponentTotal().get(k));
                            statDataList.add(statData);
                        }
                    }
                }
            }

            return;
        }

    }

    public static List<StatData> getStatDataList() {
        return statDataList;
    }
}
