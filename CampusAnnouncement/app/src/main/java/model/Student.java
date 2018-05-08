package model;

import com.google.gson.annotations.SerializedName;

public class Student extends Person{

    @SerializedName("department")
    private Department department;

    @SerializedName("semester")
    private int semester;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
