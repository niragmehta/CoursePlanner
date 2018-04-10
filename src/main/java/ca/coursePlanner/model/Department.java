package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private int deptId;


    Department(){}


    public Department(String name, int deptId) {
        this.name = name;
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
