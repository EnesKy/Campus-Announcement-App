package com.bilalekrem.campusannouncementwebservice.repository;

import com.bilalekrem.campusannouncementwebservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

}
