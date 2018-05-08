package com.bilalekrem.campusannouncementwebservice.controller;

import com.bilalekrem.campusannouncementwebservice.model.*;
import com.bilalekrem.campusannouncementwebservice.repository.AnnouncementRepository;
import com.bilalekrem.campusannouncementwebservice.repository.DepartmentRepository;
import com.bilalekrem.campusannouncementwebservice.repository.FacultyRepository;
import com.bilalekrem.campusannouncementwebservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    AnnouncementRepository announcementRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/a")
    public void a() {
        Announcement a = new Announcement();
        a.setAuthor(personRepository.getOne("0"));
        a.setTitle("başlık Bilal");
        a.setContent("İçerik Bilal");
        a.getDepartments().add(departmentRepository.getOne(1    ));

        announcementRepository.save(a);

        a = new Announcement();
        a.setAuthor(personRepository.getOne("1"));
        a.setTitle("Başlık Samet");
        a.setContent("İçerik Samet");
        a.getDepartments().add(departmentRepository.getOne(1    ));


        announcementRepository.save(a);
    }

    @RequestMapping("f")
    public void f() {
        Faculty f = new Faculty();
        f.setName("Mühendislik Fakültesi");

        facultyRepository.save(f);
    }

    @RequestMapping("d")
    public void d() {
        Department d = new Department();
        d.setName("Bilgisayar Mühendisliği");
        d.setFaculty(facultyRepository.getOne(1));

        departmentRepository.save(d);
    }

    @RequestMapping("p")
    public void p(){
        Student s = new Student();
        s.setId("0");
        s.setName("Bilal");
        s.setSurname("Harmansa");
        s.setPassword("b");
        s.setEmail("beh@");
        s.setDepartment(departmentRepository.getOne(1));

        Instructor i = new Instructor();
        i.setId("1");
        i.setName("Samet");
        i.setSurname("Kaya");
        i.setEmail("samet@");
        i.setPassword("i");
        i.setFaculty(facultyRepository.getOne(1));

        personRepository.save(s);
        personRepository.save(i);
    }
}
