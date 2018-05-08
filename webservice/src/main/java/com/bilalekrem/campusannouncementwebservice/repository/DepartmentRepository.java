package com.bilalekrem.campusannouncementwebservice.repository;

import com.bilalekrem.campusannouncementwebservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
