package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is a collection of all the departmentList at SFU.
 */
public class DepartmentCollection {
    private List<Department> departmentList = new ArrayList<>();
    private static DepartmentCollection instance = null;
    AtomicInteger id = new AtomicInteger();

    public DepartmentCollection() {
    }

    public static DepartmentCollection getInstance() {
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

    private void populate() {
        departmentList = new ArrayList<>();

        TopicCollection topics = TopicCollection.getInstance();
        List<Topic> topicList = topics.getTopicList();

        if (topicList.isEmpty()) {
            return;
        }

        Department department = new Department();
        department.setName(topicList.get(0).getSubject());
        department.setDeptId(id.incrementAndGet());

        for (int i = 0; i < topicList.size(); i++) {
            //check for when we reach the last element
            if (department.getName().equals(topicList.get(i).getSubject())) {
                department.getTopics().add(topicList.get(i));
            }
            else if (!department.getName().equals(topicList.get(i).getSubject())) {
                departmentList.add(department);
                department = new Department();
                department.setName(topicList.get(i).getSubject());
                department.setDeptId(id.incrementAndGet());
                department.getTopics().add(topicList.get(i));
                }
            if (i == topicList.size() - 1) {
                departmentList.add(department);
                return;
            }
        }

    }
}
