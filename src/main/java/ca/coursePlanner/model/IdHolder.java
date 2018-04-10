package ca.coursePlanner.model;

public class IdHolder {
    int courseId;
    int deptId;

    public IdHolder(){}

    public IdHolder(int courseId, int deptId) {
        this.courseId = courseId;
        this.deptId = deptId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
