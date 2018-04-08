package ca.coursePlanner.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is a collection of all the departmentToDeleteLaterList at SFU.
 */
public class DepartmentCollection {
    private List<DepartmentToDeleteLater> departmentToDeleteLaterList = new ArrayList<>();
    private static DepartmentCollection instance = null;

    DepartmentCollection() {
    }

    public static DepartmentCollection getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new DepartmentCollection();
            instance.populate();
        }
        return instance;
    }

    public List<DepartmentToDeleteLater> getDepartmentToDeleteLaterList() {
        return departmentToDeleteLaterList;
    }

    public void setDepartmentToDeleteLaterList(List<DepartmentToDeleteLater> departmentToDeleteLaterList) {
        this.departmentToDeleteLaterList = departmentToDeleteLaterList;
    }

    private void populate() throws FileNotFoundException {
        departmentToDeleteLaterList = new ArrayList<>();
        AtomicInteger deptId = new AtomicInteger();
        AtomicInteger courseId = new AtomicInteger();
        
        TopicCollection topics = TopicCollection.getInstance();
        List<Topic> topicList = topics.getTopicList();

        if (topicList.isEmpty()) {
            return;
        }

        DepartmentToDeleteLater departmentToDeleteLater = new DepartmentToDeleteLater();
        departmentToDeleteLater.setName(topicList.get(0).getSubject());
        departmentToDeleteLater.setDeptId(deptId.incrementAndGet());
        
        for (int i = 0; i < topicList.size(); i++) {
            //check for when we reach the last element
            if (departmentToDeleteLater.getName().equals(topicList.get(i).getSubject())) {
                topicList.get(i).setCourseId(courseId.incrementAndGet());
                departmentToDeleteLater.getTopics().add(topicList.get(i));
            }
            else if (!departmentToDeleteLater.getName().equals(topicList.get(i).getSubject())) {
                courseId=new AtomicInteger();
                departmentToDeleteLaterList.add(departmentToDeleteLater);
                departmentToDeleteLater = new DepartmentToDeleteLater();
                departmentToDeleteLater.setName(topicList.get(i).getSubject());
                departmentToDeleteLater.setDeptId(deptId.incrementAndGet());
                topicList.get(i).setCourseId(courseId.incrementAndGet());
                departmentToDeleteLater.getTopics().add(topicList.get(i));
                }
            if (i == topicList.size() - 1) {
                departmentToDeleteLaterList.add(departmentToDeleteLater);
                return;
            }
        }

    }
}
