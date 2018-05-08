package com.bilalekrem.campusannouncementwebservice.controller;

import com.bilalekrem.campusannouncementwebservice.model.Department;
import com.bilalekrem.campusannouncementwebservice.repository.DepartmentRepository;
import com.bilalekrem.campusannouncementwebservice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    FacultyRepository facultyRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable(value="id") int id) {
        Department d = departmentRepository.getOne(id);

        if(d == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(d, HttpStatus.OK);
    }
}

