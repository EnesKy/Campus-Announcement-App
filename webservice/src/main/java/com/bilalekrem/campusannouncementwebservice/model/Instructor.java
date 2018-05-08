package com.bilalekrem.campusannouncementwebservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="instructors")
@PrimaryKeyJoinColumn(name = "person_id")
@EntityListeners(AuditingEntityListener.class)
public class Instructor extends Person {

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    @JsonManagedReference
    private Faculty faculty;

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
