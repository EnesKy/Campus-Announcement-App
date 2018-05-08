package com.bilalekrem.campusannouncementwebservice.repository;

import com.bilalekrem.campusannouncementwebservice.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
