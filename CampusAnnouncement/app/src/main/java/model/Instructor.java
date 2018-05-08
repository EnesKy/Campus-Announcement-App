package model;

import com.google.gson.annotations.SerializedName;

public class Instructor extends Person {
    @SerializedName("faculty")
    private Faculty faculty;

    @SerializedName("title")
    private String title;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
