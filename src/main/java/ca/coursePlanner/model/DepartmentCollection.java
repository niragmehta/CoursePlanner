package ca.coursePlanner.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is a collection of all the departmentList at SFU.
 */
public class DepartmentCollection {
    private List<Department> departmentList = new ArrayList<>();
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

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    private void populate() throws FileNotFoundException {
        departmentList = new ArrayList<>();
        AtomicInteger deptId = new AtomicInteger();
        AtomicInteger courseId = new AtomicInteger();
        
        TopicCollection topics = TopicCollection.getInstance();
        List<Topic> topicList = topics.getTopicList();

        if (topicList.isEmpty()) {
            return;
        }

        Department departmentToDeleteLater = new Department();
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
                departmentList.add(departmentToDeleteLater);
                departmentToDeleteLater = new Department();
                departmentToDeleteLater.setName(topicList.get(i).getSubject());
                departmentToDeleteLater.setDeptId(deptId.incrementAndGet());
                topicList.get(i).setCourseId(courseId.incrementAndGet());
                departmentToDeleteLater.getTopics().add(topicList.get(i));
                }
            if (i == topicList.size() - 1) {
                departmentList.add(departmentToDeleteLater);
                return;
            }
        }

    }
}
