package model;

import com.google.gson.annotations.SerializedName;

import java.util.HashSet;
import java.util.Set;

public class Department {
    @SerializedName("id")
    private int id;

    @SerializedName("faculty")
    private Faculty faculty;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("students")
    private Set<Student> students = new HashSet<>();

    @SerializedName("announcements")
    private Set<Announcement> announcements = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Set<Announcement> announcements) {
        this.announcements = announcements;
    }
}
