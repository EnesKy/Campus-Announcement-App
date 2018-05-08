package com.bilalekrem.campusannouncementwebservice.controller;

import com.bilalekrem.campusannouncementwebservice.model.Faculty;
import com.bilalekrem.campusannouncementwebservice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getById(@PathVariable(value="id") int id) {
        Faculty f = repository.getOne(id);

        if(f == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(f, HttpStatus.OK);
    }
}
