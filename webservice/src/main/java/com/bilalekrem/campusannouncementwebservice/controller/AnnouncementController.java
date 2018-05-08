package com.bilalekrem.campusannouncementwebservice.controller;

import com.bilalekrem.campusannouncementwebservice.model.Announcement;
import com.bilalekrem.campusannouncementwebservice.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    AnnouncementRepository repository;

    @RequestMapping("/all")
    public ResponseEntity<List<Announcement>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/dept")
    public ResponseEntity<List<Announcement>> getByDeptID(@RequestParam(value = "id") int id) {
        List<Announcement> list = repository.findByDepId(id).orElse(new ArrayList<>());
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}
