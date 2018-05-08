package com.bilalekrem.campusannouncementwebservice.controller;

import com.bilalekrem.campusannouncementwebservice.model.Person;
import com.bilalekrem.campusannouncementwebservice.repository.FacultyRepository;
import com.bilalekrem.campusannouncementwebservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable(value = "id") String id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("No person with given id"));
    }

    @GetMapping("/login")
    public ResponseEntity<Person> attemptLogin(@RequestParam(value = "id") String id,
                                                @RequestParam(value = "pass") String pass) {
        Person p = personRepository.getOne(id);

        if (p == null) {
            return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
        }

        if (!p.getPassword().equals(pass)) {
            return new ResponseEntity<Person>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<Person>(HttpStatus.OK);
    }

}
