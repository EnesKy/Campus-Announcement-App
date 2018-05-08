package com.bilalekrem.campusannouncementwebservice.repository;

import com.bilalekrem.campusannouncementwebservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
