package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentToDeleteLater {
    int deptId;
    String name;
    List<Topic> topics = new ArrayList<>();

    public DepartmentToDeleteLater() {
    }

    public DepartmentToDeleteLater(int deptId, String name) {
        this.deptId = deptId;
        this.name = name;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
