package com.bilalekrem.campusannouncementwebservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="students")
@PrimaryKeyJoinColumn(name = "person_id")
@EntityListeners(AuditingEntityListener.class)
public class Student extends Person{

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    @JsonManagedReference
    private Department department;

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
