package com.bilalekrem.campusannouncementwebservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="persons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @Column(name = "person_id")
    private String id;

    @Column(nullable = false)
    //@NotBlank
    private String email;

    @Column(nullable = false)
    //@NotBlank
    private String password;

    @Column(nullable = false)
    //@NotBlank
    private String name;


    private String secondName;

    @Column(nullable = false)
    //@NotBlank
    private String surname;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date registerAt;

    @ManyToMany(mappedBy = "author")
    @JsonBackReference
    Set<Announcement> announcements = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
    }
}

/**
 * ref
 * http://www.baeldung.com/hibernate-inheritance
 * https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
 * */